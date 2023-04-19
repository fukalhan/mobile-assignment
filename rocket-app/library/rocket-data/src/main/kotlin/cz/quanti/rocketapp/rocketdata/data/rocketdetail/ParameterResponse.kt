package cz.quanti.rocketapp.rocketdata.data.rocketdetail

import com.google.gson.annotations.SerializedName

internal data class HeightResponse(
    @SerializedName("meters")
    val value: Double
)

internal data class DiameterResponse(
    @SerializedName("meters")
    val value: Double
)

internal data class MassResponse(
    @SerializedName("kg")
    val value: Int
)
