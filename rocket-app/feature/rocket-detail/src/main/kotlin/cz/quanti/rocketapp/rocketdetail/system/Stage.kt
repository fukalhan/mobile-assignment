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

        StageParameter(stageState.reusable.iconRes, stageState.reusable.stringRes)
        Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.mediumSpacer))

        StageParameter(stageState.engines.iconRes, stageState.engines.stringRes)
        Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.mediumSpacer))

        StageParameter(stageState.fuelAmount.iconRes, stageState.fuelAmount.stringRes)
        Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.mediumSpacer))

        StageParameter(stageState.burnTime.iconRes, stageState.burnTime.stringRes)
        Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.mediumSpacer))
    }
}

@Composable
private fun StageParameter(iconRes: Int, messageRes: @Composable () -> String) {
    Row {
        Image(
            painter = painterResource(iconRes),
            contentDescription = "Icon"
        )

        Spacer(modifier = Modifier.width(RocketAppTheme.dimensions.mediumSpacer))

        Text(
            text = messageRes(),
            style = RocketAppTheme.typography.body,
            color = RocketAppTheme.colors.textPrimary
        )
    }
}
