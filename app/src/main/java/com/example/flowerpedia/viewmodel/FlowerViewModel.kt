package com.example.flowerpedia.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flowerpedia.api.ApiClient
import com.example.flowerpedia.model.Flower
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlowerViewModel : ViewModel() {

    private val _flowers = MutableLiveData<List<Flower>>()
    val flowers: LiveData<List<Flower>> get() = _flowers

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    init {
        fetchFlowers()
    }

    private fun fetchFlowers() {
        ApiClient.apiService.getFlowers().enqueue(object : Callback<List<Flower>> {
            override fun onResponse(call: Call<List<Flower>>, response: Response<List<Flower>>) {
                if (response.isSuccessful) {
                    _flowers.value = response.body()
                } else {
                    // Handle the case where the response is not successful
                    _error.value = "ERROR: ${response.message()}"
                }
            }

            override fun onFailure(call: Call<List<Flower>>, t: Throwable) {
                Log.e("FlowerViewModel", "Failed to fetch flowers", t)

                // Update the Livedata to notify the UI about the error
                _error.value = "Failed to load flowers. Please try again later."
            }
        })
    }
}