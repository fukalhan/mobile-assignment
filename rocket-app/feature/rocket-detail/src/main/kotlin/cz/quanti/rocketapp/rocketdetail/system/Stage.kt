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
import androidx.compose.ui.unit.dp
import cz.quanti.rocketapp.design.system.RocketAppTheme
import cz.quanti.rocketapp.rocketdetail.presentation.StageOrder
import cz.quanti.rocketapp.rocketdetail.presentation.StageState

@Composable
fun Stage(stageState: StageState, stageOrder: StageOrder) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(RocketAppTheme.dimensions.roundCorners))
            .background(RocketAppTheme.colors.background)
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = stageOrder.order,
            style = RocketAppTheme.typography.cardTitle,
            color = RocketAppTheme.colors.textPrimary
        )
        Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.mediumSpacer))

        StageParameter(stageState.reusable.iconRes, stageState.reusable.text)
        Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.mediumSpacer))

        StageParameter(stageState.engines.iconRes, stageState.engines.text)
        Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.mediumSpacer))

        StageParameter(stageState.fuelAmount.iconRes, stageState.fuelAmount.text)
        Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.mediumSpacer))

        StageParameter(stageState.burnTime.iconRes, stageState.burnTime.text)
        Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.mediumSpacer))
    }
}

@Composable
fun StageParameter(iconRes: Int, text: String) {
    Row {
        Image(
            painter = painterResource(iconRes),
            contentDescription = "Icon"
        )

        Spacer(modifier = Modifier.width(RocketAppTheme.dimensions.mediumSpacer))

        Text(
            text = text,
            style = RocketAppTheme.typography.cardBody,
            color = RocketAppTheme.colors.textPrimary
        )
    }
}
