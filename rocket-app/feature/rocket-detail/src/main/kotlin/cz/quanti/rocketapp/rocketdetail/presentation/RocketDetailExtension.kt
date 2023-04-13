package cz.quanti.rocketapp.rocketdetail.presentation

import cz.quanti.rocketapp.design.presentation.StringResources
import cz.quanti.rocketapp.rocketdata.model.rocketdetail.RocketDetail
import cz.quanti.rocketapp.rocketdata.model.rocketdetail.Stage
import cz.quanti.rocketapp.rocketdetail.R
import kotlin.math.roundToInt

internal fun RocketDetail.toRocketDetailState(
    stringResources: StringResources
): RocketDetailState {
    return RocketDetailState(
        name = this.name,
        overview = this.overview,
        height = ParameterState(
            stringResources.getString(R.string.heightVal, round(this.height)),
            stringResources.getString(R.string.height)
        ),
        diameter = ParameterState(
            stringResources.getString(R.string.diameterVal, round(this.diameter)),
            stringResources.getString(R.string.diameter)
        ),
        mass = ParameterState(
            stringResources.getString(R.string.massVal, this.mass),
            stringResources.getString(R.string.mass)
        ),
        firstStage = this.firstStage.toStageState(stringResources),
        secondStage = this.secondStage.toStageState(stringResources),
        images = this.images
    )
}

internal fun Stage.toStageState(
    stringResources: StringResources
): StageState {
    val reusable = if (this.reusable) {
        StageParameter(R.drawable.reusable, stringResources.getString(R.string.reusable))
    } else {
        StageParameter(R.drawable.reusable, stringResources.getString(R.string.notReusable))
    }
    return StageState(
        reusable,
        StageParameter(R.drawable.engine, stringResources.getString(R.string.enginesNum, this.engines)),
        StageParameter(R.drawable.fuel, stringResources.getString(R.string.fuelAmount, round(this.fuelAmount))),
        StageParameter(R.drawable.burn, stringResources.getString(R.string.burnTime, round(this.burnTime)))
    )
}

const val ROUNDING_VAL = 100.0
private fun round(num: Double): Double = (num * ROUNDING_VAL).roundToInt() / ROUNDING_VAL
