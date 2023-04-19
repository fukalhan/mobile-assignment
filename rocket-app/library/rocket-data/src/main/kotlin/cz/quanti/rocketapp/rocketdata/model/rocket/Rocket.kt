package cz.quanti.rocketapp.rocketdata.model.rocket

import java.time.LocalDate

data class Rocket(
    val id: String,
    val name: String,
    val firstFlight: LocalDate
)
