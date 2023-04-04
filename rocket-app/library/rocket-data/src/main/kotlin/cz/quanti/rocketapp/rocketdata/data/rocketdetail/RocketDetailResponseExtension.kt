package cz.quanti.rocketapp.rocketdata.data.rocketdetail

import cz.quanti.rocketapp.rocketdata.model.rocketdetail.RocketDetail
import cz.quanti.rocketapp.rocketdata.model.rocketdetail.Stage

internal fun RocketDetailResponse.toRocketDetail(): RocketDetail {
    return RocketDetail(
        id = this.id,
        name = this.name,
        overview = this.description,
        height = this.height.value,
        diameter = this.diameter.value,
        mass = this.mass.value,
        firstStage = Stage(
            this.firstStage.reusable,
            this.firstStage.engines,
            this.firstStage.fuelAmount,
            this.firstStage.burnTime
        ),
        secondStage = Stage(
            this.secondStage.reusable,
            this.secondStage.engines,
            this.secondStage.fuelAmount,
            this.secondStage.burnTime
        )
    )
}
