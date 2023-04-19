package cz.quanti.rocketapp.rocketdata.data.rocketdetail

import com.google.gson.annotations.SerializedName

internal data class StageResponse(
    @SerializedName("reusable")
    val reusable: Boolean = false,
    @SerializedName("engines")
    val engines: Int,
    @SerializedName("fuel_amount_tons")
    val fuelAmount: Double,
    @SerializedName("burn_time_sec")
    val burnTime: Double
)
