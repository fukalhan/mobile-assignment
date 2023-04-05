package cz.quanti.rocketapp.rocketdata.data.rocketdetail

import cz.quanti.rocketapp.rocketdata.model.rocketdetail.RocketDetail

internal fun RocketDetailResponse.toRocketDetail(): RocketDetail {
    return RocketDetail(
        id = this.id,
        name = this.name,
        overview = this.description,
        height = this.height.value,
        diameter = this.diameter.value,
        mass = this.mass.value,
        firstStage = this.firstStage.toStage(),
        secondStage = this.secondStage.toStage(),
        images = this.images
    )
}
