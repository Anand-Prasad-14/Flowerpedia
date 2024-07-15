package com.example.flowerpedia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flowerpedia.R
import com.example.flowerpedia.model.Flower

class FlowerAdapter(private val onClick: (Flower) -> Unit) : RecyclerView.Adapter<FlowerViewHolder>() {

    private var flowers: List<Flower> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_flower, parent, false)
        return FlowerViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        holder.bind(flowers[position])
    }

    override fun getItemCount(): Int = flowers.size

    fun submitList(newFlowers: List<Flower>) {
        flowers = newFlowers
        notifyDataSetChanged()
    }
}