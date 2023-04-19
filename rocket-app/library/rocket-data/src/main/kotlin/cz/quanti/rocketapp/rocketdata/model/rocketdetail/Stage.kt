package cz.quanti.rocketapp.rocketdata.model.rocketdetail

data class Stage(
    val reusable: Boolean,
    val engines: Int,
    val fuelAmount: Double,
    val burnTime: Double
)
