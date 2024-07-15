package com.example.flowerpedia.model

import java.io.Serializable

data class Flower(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String
) : Serializable
