package com.example.projekflight.ui.flight_screen

import androidx.compose.foundation.layout.*

import androidx.compose.material.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder

import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.projekflight.data.MockData
import com.example.projekflight.ui.search.AirportRow

@Composable
fun FlightRow(
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    departureAirportCode: String,
    departureAirportName: String,
    destinationAirportCode: String,
    destinationairportName: String,
    onFavoriteClick: (String, String) -> Unit
){
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ){
Row{
    Column(modifier = modifier.weight(10f)){
        Column{
            Text(
                text = "Depart",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(start = 32.dp)
            )
            AirportRow(code = departureAirportCode, name = departureAirportName)
            Text(
                text = "Arrival",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(start = 32.dp)
            )
            AirportRow(code = destinationAirportCode, name= destinationairportName)
        }
    }

    IconButton(onClick = {
        onFavoriteClick(departureAirportCode, destinationAirportCode)
    },
        modifier = Modifier.align(Alignment.CenterVertically)
        ){
        Icon(
            imageVector = if(isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
            tint = if(isFavorite) Color.Red else Color.LightGray,
            contentDescription = null
        )
    }
}
    }

}

@Preview
@Composable
fun FlightRowPreview(){
    val mock = MockData

    FlightRow(
        isFavorite = true,
        departureAirportCode = mock.airports[1].code,
        departureAirportName = mock.airports[1].name,
        destinationAirportCode = mock.airports[2].code,
        destinationairportName = mock.airports[2].name,
        onFavoriteClick = {
                _: String,
                _:String ->
        }
    )
}