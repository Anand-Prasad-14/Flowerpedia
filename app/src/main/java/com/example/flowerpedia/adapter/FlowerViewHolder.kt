package com.example.flowerpedia.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flowerpedia.R
import com.example.flowerpedia.model.Flower

class FlowerViewHolder(itemView: View, private val onClick: (Flower) -> Unit) : RecyclerView.ViewHolder(itemView) {

    private val flowerName: TextView = itemView.findViewById(R.id.flowerName)
    private val flowerImage: ImageView = itemView.findViewById(R.id.flowerImage)
    private var currentFlower: Flower? = null

    init {
        itemView.setOnClickListener {
            currentFlower?.let {
                onClick(it)
            }
        }
    }

    fun bind(flower: Flower) {
        currentFlower = flower
        flowerName.text = flower.name
        Glide.with(itemView.context)
            .load(flower.imageUrl)
            .into(flowerImage)
    }
}