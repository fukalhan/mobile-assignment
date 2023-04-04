package cz.quanti.rocketapp.rocketdetail.presentation

data class RocketDetailState(
    val name: String = "",
    val overview: String = "",
    val height: ParameterState = ParameterState.HeightState(0.0),
    val diameter: ParameterState = ParameterState.DiameterState(0.0),
    val mass: ParameterState = ParameterState.MassState(0),
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
