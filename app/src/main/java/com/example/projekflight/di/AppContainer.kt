package com.example.projekflight.di

import android.content.Context

import com.example.projekflight.data.FlightRepository
import com.example.projekflight.data.FlightDatabase
import com.example.projekflight.data.OfflineFlightRepository

interface AppContainer{
    val flightRepository: FlightRepository
}

class AppDataContainer(private val context: Context): AppContainer{
    override val flightRepository: FlightRepository by lazy{
        OfflineFlightRepository(FlightDatabase.getDatabase(context).flightDao())
    }
}