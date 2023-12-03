package com.example.projekflight.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projekflight.model.Airport
import com.example.projekflight.model.Favorite

@Database(entities = [Airport::class, Favorite::class], version = 1)
abstract class FlightDatabase: RoomDatabase() {

   abstract fun flightDao(): FlightDao

   companion object {
       @Volatile
       private var Instance: FlightDatabase? = null

       fun getDatabase(context: Context): FlightDatabase{
           return Instance ?: synchronized(this){
               Room.databaseBuilder(context, FlightDatabase::class.java, "flight_database")
                   .createFromAsset("database/flight_search.db")
                   .build()
                   .also{
                       Instance = it
                   }
           }
       }


   }

}