package cz.quanti.rocketapp.rocketdetail.presentation

import cz.quanti.rocketapp.rocketdata.model.rocketdetail.RocketDetail
import cz.quanti.rocketapp.rocketdata.model.rocketdetail.Stage

internal fun RocketDetail.toRocketDetailState(): RocketDetailState {
    return RocketDetailState(
        name = this.name,
        overview = this.overview,
        height = ParameterState.HeightState(this.height),
        diameter = ParameterState.DiameterState(this.diameter),
        mass = ParameterState.MassState(this.mass),
        firstStage = this.firstStage.toStageState(),
        secondStage = this.secondStage.toStageState(),
        images = this.images
    )
}

internal fun Stage.toStageState(): StageState {
    return StageState(
        Reusable(this.reusable),
        Engines(this.engines),
        Fuel(this.fuelAmount),
        BurnTime(this.burnTime)
    )
}
