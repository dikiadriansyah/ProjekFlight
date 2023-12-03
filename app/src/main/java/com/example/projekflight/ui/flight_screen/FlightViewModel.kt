package com.example.projekflight.ui.flight_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.projekflight.FlightApplication
import com.example.projekflight.data.FlightRepository
import com.example.projekflight.model.Favorite
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FlightViewModel(
    savedStateHandle: SavedStateHandle,
    val flightRepository:FlightRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(FlightUiState())
    val uiState: StateFlow<FlightUiState> = _uiState

    private val airportCode: String = savedStateHandle[FlightScreenDestination.codeArg] ?: ""

    var flightAdded: Boolean by mutableStateOf(false)

    init{
        viewModelScope.launch {
            processFlightList(airportCode)
        }
    }

    private fun processFlightList(airportCode: String){
        viewModelScope.launch {
            val ff = flightRepository.getAllFavoritesFlights().toMutableList()
            val aa = flightRepository.getAllAirports().toMutableStateList()
            val departureAirport = aa.first{
                it.code == airportCode
            }

            _uiState.update {
                uiState.value.copy(
                    code= airportCode,
                    favoriteList = ff,
                    destinationList = aa,
                    depatureAirport = departureAirport
                )
            }

        }
    }

    fun addFavoriteFlight(depatureCode: String, destinationCode: String){
        viewModelScope.launch {
            val favorite: Favorite = flightRepository.getSingleFavorite(depatureCode, destinationCode)

            if(favorite == null){
                val tmp = Favorite(
                    departureCode = depatureCode,
                    destinationCode = destinationCode
                )
                flightAdded = true
                flightRepository.insertFavoriteFlight(tmp)

            }else{
                flightAdded = false
                flightRepository.deleteFavoriteFlight(favorite)
            }

            val play = flightRepository.getAllFavoritesFlights()
            _uiState.update {
                uiState.value.copy(
                    favoriteList = play
                )
            }
        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory{
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as FlightApplication)

                val flightRepository = application.container.flightRepository

                FlightViewModel(this.createSavedStateHandle(), flightRepository = flightRepository)
            }
        }
    }

}