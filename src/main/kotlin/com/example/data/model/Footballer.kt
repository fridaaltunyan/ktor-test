package com.example.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Footballer(
    val id: Long,
    val name: String,
    val position: FootballerPositionEnum,
    val clubName: String,
    val imageUrl: String,
)
