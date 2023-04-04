package cz.quanti.rocketapp.rocketdetail.presentation

import cz.quanti.rocketapp.rocketdata.model.rocketdetail.RocketDetail

internal fun RocketDetail.toRocketDetailState(): RocketDetailState {
    return RocketDetailState(
        name = this.name,
        overview = this.overview,
        height = ParameterState.HeightState(this.height),
        diameter = ParameterState.DiameterState(this.diameter),
        mass = ParameterState.MassState(this.mass)
    )
}
