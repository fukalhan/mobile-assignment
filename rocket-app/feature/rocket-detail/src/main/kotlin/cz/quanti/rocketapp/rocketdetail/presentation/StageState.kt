package cz.quanti.rocketapp.rocketdetail.presentation

import cz.quanti.rocketapp.rocketdetail.R

data class StageState(
    val reusable: StageParameter = Reusable(),
    val engines: StageParameter = Engines(),
    val fuelAmount: StageParameter = Fuel(),
    val burnTime: StageParameter = BurnTime()
)

sealed class StageParameter(
    val iconRes: Int,
    val text: String
)

class Reusable(reusable: Boolean = false) : StageParameter(
    R.drawable.reusable,
    if (reusable) "reusable" else "not reusable"
)
class Engines(enginesNum: Int = 0) : StageParameter(R.drawable.engine, "$enginesNum engines")
class Fuel(fuelAmount: Double = 0.0) : StageParameter(R.drawable.fuel, "$fuelAmount tons of fuel")
class BurnTime(burnTime: Double = 0.0) : StageParameter(R.drawable.burn, "$burnTime seconds burn time")

enum class StageOrder(val order: String) {
    FIRST_STAGE("First stage"),
    SECOND_STAGE("Second stage")
}
