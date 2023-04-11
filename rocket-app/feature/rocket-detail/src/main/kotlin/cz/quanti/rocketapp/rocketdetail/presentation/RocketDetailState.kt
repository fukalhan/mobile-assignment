package cz.quanti.rocketapp.rocketdetail.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import cz.quanti.rocketapp.rocketdetail.R

data class RocketDetailState(
    val name: String = "",
    val overview: String = "",
    val height: ParameterState = ParameterState.HeightState(0.0),
    val diameter: ParameterState = ParameterState.DiameterState(0.0),
    val mass: ParameterState = ParameterState.MassState(0),
    val firstStage: StageState = StageState(),
    val secondStage: StageState = StageState(),
    val images: List<String> = emptyList()
)

sealed class ParameterState(
    val value: String,
    val type: ParameterType
) {
    data class HeightState(val height: Double) : ParameterState("${height}m", ParameterType.HEIGHT)
    data class DiameterState(val diameter: Double) : ParameterState(
        "${diameter}m",
        ParameterType.DIAMETER
    )
    data class MassState(val mass: Int) : ParameterState("${mass}t", ParameterType.MASS)
}

enum class ParameterType(val paramName: String) {
    HEIGHT("height"),
    DIAMETER("diameter"),
    MASS("mass")
}

data class StageState(
    val reusable: StageParameter = Reusable(),
    val engines: StageParameter = Engines(),
    val fuelAmount: StageParameter = Fuel(),
    val burnTime: StageParameter = BurnTime()
)

sealed class StageParameter(
    val iconRes: Int,
    val stringRes: @Composable () -> String
)

class Reusable(reusable: Boolean = false) : StageParameter(
    R.drawable.reusable,
    {
        if (reusable) stringResource(R.string.reusable) else stringResource(R.string.notReusable)
    }
)
class Engines(enginesNum: Int = 0) : StageParameter(
    R.drawable.engine,
    {
        stringResource(R.string.enginesNum, enginesNum)
    }
)

class Fuel(fuelAmount: Double = 0.0) : StageParameter(
    R.drawable.fuel,
    {
        stringResource(R.string.fuelAmount, fuelAmount)
    }
)
class BurnTime(burnTime: Double = 0.0) : StageParameter(
    R.drawable.burn,
    {
        stringResource(R.string.burnTime, burnTime)
    }
)

enum class StageOrder(val orderRes: Int) {
    FIRST_STAGE(R.string.firstStage),
    SECOND_STAGE(R.string.secondStage)
}
