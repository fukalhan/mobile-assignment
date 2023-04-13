package cz.quanti.rocketapp.rocketdetail.system

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import cz.quanti.rocketapp.design.system.RocketAppTheme
import cz.quanti.rocketapp.rocketdetail.presentation.StageOrder
import cz.quanti.rocketapp.rocketdetail.presentation.StageState

@Composable
internal fun Stage(stageState: StageState, stageOrder: StageOrder) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(RocketAppTheme.dimensions.roundCorners))
            .background(RocketAppTheme.colors.background)
            .fillMaxWidth()
            .padding(RocketAppTheme.dimensions.sidePadding)
    ) {
        Text(
            text = stringResource(stageOrder.orderRes),
            style = RocketAppTheme.typography.title,
            color = RocketAppTheme.colors.textPrimary
        )
        Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.mediumSpacer))

        StageParameter(stageState.reusable.iconRes, stageState.reusable.parameterString)
        StageParameter(stageState.engines.iconRes, stageState.engines.parameterString)
        StageParameter(stageState.fuelAmount.iconRes, stageState.fuelAmount.parameterString)
        StageParameter(stageState.burnTime.iconRes, stageState.burnTime.parameterString)
    }
    Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.largeSpacer))
}

@Composable
private fun StageParameter(iconRes: Int, text: String) {
    Row {
        Image(
            painter = painterResource(iconRes),
            contentDescription = "Icon"
        )

        Spacer(modifier = Modifier.width(RocketAppTheme.dimensions.mediumSpacer))

        Text(
            text = text,
            style = RocketAppTheme.typography.body,
            color = RocketAppTheme.colors.textPrimary
        )
    }
    Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.mediumSpacer))
}
