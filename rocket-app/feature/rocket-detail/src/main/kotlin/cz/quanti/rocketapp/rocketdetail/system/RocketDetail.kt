package cz.quanti.rocketapp.rocketdetail.system

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cz.quanti.rocketapp.design.system.RocketAppTheme
import cz.quanti.rocketapp.rocketdetail.R
import cz.quanti.rocketapp.rocketdetail.presentation.RocketDetailState
import cz.quanti.rocketapp.rocketdetail.presentation.StageOrder

@Composable
fun RocketDetail(rocketState: RocketDetailState) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .background(RocketAppTheme.colors.componentBackground)
            .verticalScroll(scrollState)
            .padding(10.dp)
    ) {
        Overview(rocketState.overview)
        Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.bigSpacer))

        ParameterRow(rocketState.height, rocketState.diameter, rocketState.mass)
        Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.bigSpacer))

        Stage(stageState = rocketState.firstStage, stageOrder = StageOrder.FIRST_STAGE)
        Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.bigSpacer))

        Stage(stageState = rocketState.secondStage, stageOrder = StageOrder.SECOND_STAGE)
    }
}

@Composable
fun Overview(overview: String) {
    Text(
        text = stringResource(R.string.overview),
        color = RocketAppTheme.colors.textPrimary,
        style = RocketAppTheme.typography.cardTitle
    )

    Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.mediumSpacer))

    Text(
        text = overview,
        color = RocketAppTheme.colors.textPrimary,
        style = RocketAppTheme.typography.cardBody
    )
}
