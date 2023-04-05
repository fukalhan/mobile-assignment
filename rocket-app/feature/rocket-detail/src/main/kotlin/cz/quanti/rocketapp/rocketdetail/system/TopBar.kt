package cz.quanti.rocketapp.rocketdetail.system

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cz.quanti.rocketapp.design.system.RocketAppTheme
import cz.quanti.rocketapp.rocketdetail.R

@Composable
fun TopBar(rocketName: String, onNavigateBack: () -> Unit) {
    TopAppBar(
        elevation = RocketAppTheme.dimensions.elevation,
        backgroundColor = RocketAppTheme.colors.background,
    ) {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            BackToRocketsTextButton(onNavigateBack)

            Text(
                text = rocketName,
                color = RocketAppTheme.colors.textPrimary,
                style = RocketAppTheme.typography.title,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 60.dp)
            )

            Text(
                text = stringResource(id = R.string.launch),
                color = Color.Blue,
                style = RocketAppTheme.typography.title,
            )
        }
    }
}

@Composable
fun BackToRocketsTextButton(onNavigateBack: () -> Unit) {
    Row(
        modifier = Modifier.clickable { onNavigateBack() }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.back_arrow),
            contentDescription = null,
            tint = Color.Blue
        )

        Text(
            text = stringResource(id = R.string.rockets),
            style = RocketAppTheme.typography.title,
            color = Color.Blue
        )
    }
}
