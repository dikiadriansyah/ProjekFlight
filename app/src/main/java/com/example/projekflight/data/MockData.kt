package com.example.projekflight.data

import com.example.projekflight.model.Airport

object MockData {

    val airports= listOf(
        Airport(
          id = 1,
            code = "OPO",
            name = "Francisco Sa Carne Airport",
            passengers = 5053134
        ),
        Airport(
            id = 2,
            code = "SAA",
            name = "Stockholm land Airport",
            passengers = 7942492
        ),
        Airport(
            id = 3,
            code = "WAW",
            name = "Warsaw Chopin Airport",
            passengers = 63242423
        ),
        Airport(
            id = 4,
            code = "MRS",
            name = "Marseille Provence Airport",
            passengers = 32142343
        ),
        Airport(
            id = 5,
            code = "BGY",
            name = "Milan Berg Airport",
            passengers = 82352332
        )
    )

}