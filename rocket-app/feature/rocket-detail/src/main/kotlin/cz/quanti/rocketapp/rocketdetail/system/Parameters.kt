package cz.quanti.rocketapp.rocketdetail.system

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import cz.quanti.rocketapp.design.system.RocketAppTheme
import cz.quanti.rocketapp.rocketdetail.R
import cz.quanti.rocketapp.rocketdetail.presentation.ParameterState

@Composable
internal fun ParameterRow(
    height: ParameterState,
    diameter: ParameterState,
    mass: ParameterState,
) {
    Text(
        text = stringResource(R.string.parameters),
        color = RocketAppTheme.colors.textPrimary,
        style = RocketAppTheme.typography.title
    )
    Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.mediumSpacer))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        val modifier = Modifier
            .weight(1f)
            .aspectRatio(1f)
            .fillMaxSize()
            .clip(RoundedCornerShape(RocketAppTheme.dimensions.roundCorners))
            .background(color = RocketAppTheme.colors.primary)

        ParameterDetail(height, modifier)
        Spacer(modifier = Modifier.width(RocketAppTheme.dimensions.largeSpacer))
        ParameterDetail(diameter, modifier)
        Spacer(modifier = Modifier.width(RocketAppTheme.dimensions.largeSpacer))
        ParameterDetail(mass, modifier)
    }
}

@Composable
private fun ParameterDetail(param: ParameterState, modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = param.value,
            style = RocketAppTheme.typography.title,
            color = RocketAppTheme.colors.cardText
        )
        Text(
            text = param.type.paramName,
            style = RocketAppTheme.typography.body,
            color = RocketAppTheme.colors.cardText
        )
    }
}
