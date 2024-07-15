package com.example.flowerpedia.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flowerpedia.R
import com.example.flowerpedia.adapter.FlowerAdapter
import com.example.flowerpedia.viewmodel.FlowerViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: FlowerViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = FlowerAdapter { flower ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("flower", flower)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        viewModel.flowers.observe(this, Observer { flowers ->
            adapter.submitList(flowers)
        })

    }
}