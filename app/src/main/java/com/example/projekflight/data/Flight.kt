package com.example.projekflight.data

data class Flight(
    val id: Int = 0,
    val departureCode: String = "",
    val depatureName: String = "",
    val destinationCode: String = "",
    val destinationName: String = "",
    val isFavorite: Boolean = false

)
