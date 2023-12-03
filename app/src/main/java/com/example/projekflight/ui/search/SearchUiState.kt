package com.example.projekflight.ui.search

import com.example.projekflight.model.Airport
import com.example.projekflight.model.Favorite

data class SearchUiState (
    val searchQuery: String = "",
    val selectedCode: String = "",
    val airportList: List<Airport> = emptyList(),
    val favoriteList: List<Favorite> = emptyList(),
)