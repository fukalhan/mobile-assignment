package cz.quanti.rocketapp.rocketdetail.system

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import cz.quanti.rocketapp.design.system.RocketAppTheme
import cz.quanti.rocketapp.rocketdetail.R
import cz.quanti.rocketapp.rocketdetail.presentation.RocketDetailState
import cz.quanti.rocketapp.rocketdetail.presentation.RocketDetailViewModel
import cz.quanti.rocketapp.rocketdetail.presentation.StageOrder

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RocketDetailScreen(
    viewModel: RocketDetailViewModel,
    id: String,
    onNavigateBack: () -> Unit,
) {
    val rocketDetailState: RocketDetailState by viewModel.rocketDetail.collectAsState()
    viewModel.initRocketDetail(id)

    Scaffold(
        topBar = { TopBar(rocketDetailState.name, onNavigateBack) },
    ) {
        RocketDetail(rocketDetailState)
    }
}

@Composable
private fun RocketDetail(rocketState: RocketDetailState) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .background(RocketAppTheme.colors.componentBackground)
            .verticalScroll(scrollState)
            .padding(RocketAppTheme.dimensions.sidePadding)
    ) {
        Overview(rocketState.overview)
        Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.largeSpacer))

        ParameterRow(rocketState.height, rocketState.diameter, rocketState.mass)
        Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.largeSpacer))

        Stage(stageState = rocketState.firstStage, stageOrder = StageOrder.FIRST_STAGE)
        Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.largeSpacer))

        Stage(stageState = rocketState.secondStage, stageOrder = StageOrder.SECOND_STAGE)
        Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.largeSpacer))

        Photos(urls = rocketState.images)
    }
}

@Composable
private fun Overview(overview: String) {
    Text(
        text = stringResource(R.string.overview),
        color = RocketAppTheme.colors.textPrimary,
        style = RocketAppTheme.typography.title
    )

    Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.mediumSpacer))

    Text(
        text = overview,
        color = RocketAppTheme.colors.textPrimary,
        style = RocketAppTheme.typography.body
    )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun RocketDetailScreenPreview() {
    Scaffold(
        topBar = { TopBar("Screen") { } },
    ) {
        RocketDetailPreview()
    }
}

@Preview
@Composable
fun RocketDetailPreview() {
    RocketDetail(rocketState = RocketDetailState())
}
