package com.example.projekflight.ui.flight_screen

import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview


import com.example.projekflight.model.Airport
import com.example.projekflight.model.Favorite
import com.example.projekflight.data.MockData

@Composable
fun FlightResults(
    modifier: Modifier = Modifier,
    departureAirport: Airport,
    destinationList: List<Airport>,
    favoriteList: List<Favorite>,
    onFavoriteClick: (String, String)->Unit
    ){
    Column{
        LazyColumn(modifier = modifier.padding(8.dp).fillMaxWidth()){
            items(destinationList, key={ it.id }){item ->
                val isFavorite = favoriteList.find{ f ->
                    f.departureCode == departureAirport.code &&
                            f.destinationCode == item.code }

                FlightRow(
                    isFavorite = isFavorite != null,
                    departureAirportCode = departureAirport.code,
                    departureAirportName = departureAirport.name,
                    destinationAirportCode = item.code,
                    destinationairportName = item.name,
                    onFavoriteClick = onFavoriteClick
                )

            }
        }
    }

}