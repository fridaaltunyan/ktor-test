package com.example.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? = null,
    val footballers: List<Footballer> = emptyList(),
    val lastUpdated: Long? = null
)
