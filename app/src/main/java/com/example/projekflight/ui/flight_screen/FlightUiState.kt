package com.example.projekflight.ui.flight_screen

import com.example.projekflight.model.Airport
import com.example.projekflight.model.Favorite

data class FlightUiState (
    val code: String = "",
    val favoriteList: List<Favorite> = emptyList(),
    val destinationList: List<Airport> = emptyList(),
    val depatureAirport: Airport = Airport()
)