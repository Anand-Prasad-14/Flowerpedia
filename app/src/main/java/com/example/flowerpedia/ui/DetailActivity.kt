package com.example.flowerpedia.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.flowerpedia.R
import com.example.flowerpedia.model.Flower

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val flower = intent.getSerializableExtra("flower") as Flower

        val flowerImageView = findViewById<ImageView>(R.id.flowerImage)
        val flowerNameView = findViewById<TextView>(R.id.flowerName)
        val flowerDescriptionView = findViewById<TextView>(R.id.flowerDescription)

        Glide.with(this)
            .load(flower.imageUrl)
            .into(flowerImageView)

        flowerNameView.text = flower.name
        flowerDescriptionView.text = flower.description
    }
}