package cz.quanti.rocketapp.rocketdata.data.rocketdetail

import cz.quanti.rocketapp.rocketdata.model.rocketdetail.Stage

internal fun StageResponse.toStage(): Stage {
    return Stage(
        this.reusable,
        this.engines,
        this.fuelAmount,
        this.burnTime
    )
}
