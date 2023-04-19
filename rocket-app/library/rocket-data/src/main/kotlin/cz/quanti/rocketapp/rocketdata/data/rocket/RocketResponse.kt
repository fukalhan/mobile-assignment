package cz.quanti.rocketapp.rocketdata.data.rocket

import com.google.gson.annotations.SerializedName

internal data class RocketResponse(
    @SerializedName("rocket_id")
    val id: String,
    @SerializedName("rocket_name")
    val name: String,
    @SerializedName("first_flight")
    val firstFlight: String
)
