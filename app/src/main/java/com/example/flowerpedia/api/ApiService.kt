package com.example.flowerpedia.api

import com.example.flowerpedia.model.Flower
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("flowers")
    fun getFlowers(): Call<List<Flower>>
}