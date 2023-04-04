package cz.quanti.rocketapp.rocketdetail.system

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cz.quanti.rocketapp.design.system.RocketAppTheme
import cz.quanti.rocketapp.rocketdetail.R
import cz.quanti.rocketapp.rocketdetail.presentation.ParameterState

@Composable
fun ParameterRow(
    height: ParameterState,
    diameter: ParameterState,
    mass: ParameterState,
) {
    Text(
        text = stringResource(R.string.parameters),
        color = RocketAppTheme.colors.textPrimary,
        style = RocketAppTheme.typography.cardTitle
    )
    Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.mediumSpacer))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ParameterDetail(height)
        ParameterDetail(diameter)
        ParameterDetail(mass)
    }
}

@Composable
fun ParameterDetail(param: ParameterState) {
    Column(
        modifier = Modifier
            .size(110.dp)
            .clip(RoundedCornerShape(RocketAppTheme.dimensions.roundCorners))
            .background(color = RocketAppTheme.colors.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = param.value,
            style = RocketAppTheme.typography.cardTitle,
            color = RocketAppTheme.colors.cardText
        )
        Text(
            text = param.type.paramName,
            style = RocketAppTheme.typography.cardBody,
            color = RocketAppTheme.colors.cardText
        )
    }
}
