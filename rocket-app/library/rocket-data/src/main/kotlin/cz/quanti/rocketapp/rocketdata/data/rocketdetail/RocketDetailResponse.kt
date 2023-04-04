package cz.quanti.rocketapp.rocketdata.data.rocketdetail

import com.google.gson.annotations.SerializedName

internal data class RocketDetailResponse(
    @SerializedName("rocket_id")
    val id: String,
    @SerializedName("rocket_name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("height")
    val height: HeightResponse,
    @SerializedName("diameter")
    val diameter: DiameterResponse,
    @SerializedName("mass")
    val mass: MassResponse,
    @SerializedName("first_stage")
    val firstStage: StageResponse,
    @SerializedName("second_stage")
    val secondStage: StageResponse
)
