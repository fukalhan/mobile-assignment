package cz.quanti.rocketapp.rocketdata.model.rocketdetail

data class RocketDetail(
    val id: String,
    val name: String,
    val overview: String,
    val height: Double,
    val diameter: Double,
    val mass: Int,
    val firstStage: Stage,
    val secondStage: Stage
)
