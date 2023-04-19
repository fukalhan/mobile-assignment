package cz.quanti.rocketapp.rocketdetail.presentation

import cz.quanti.rocketapp.rocketdetail.R

data class RocketDetailState(
    val name: String = "",
    val overview: String = "",
    val height: ParameterState = ParameterState(),
    val diameter: ParameterState = ParameterState(),
    val mass: ParameterState = ParameterState(),
    val firstStage: StageState = StageState(),
    val secondStage: StageState = StageState(),
    val images: List<String> = emptyList()
)

data class ParameterState(
    val value: String = "",
    val label: String = ""
)

data class StageState(
    val reusable: StageParameter = StageParameter(R.drawable.reusable),
    val engines: StageParameter = StageParameter(R.drawable.engine),
    val fuelAmount: StageParameter = StageParameter(R.drawable.fuel),
    val burnTime: StageParameter = StageParameter(R.drawable.burn)
)

data class StageParameter(
    val iconRes: Int,
    val parameterString: String = "",
)

enum class StageOrder(val orderRes: Int) {
    FIRST_STAGE(R.string.firstStage),
    SECOND_STAGE(R.string.secondStage)
}
