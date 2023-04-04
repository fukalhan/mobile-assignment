package cz.quanti.rocketapp.rocketdetail.system

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cz.quanti.rocketapp.rocketdetail.presentation.RocketDetailState
import cz.quanti.rocketapp.rocketdetail.presentation.RocketDetailViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RocketDetailScreen(
    viewModel: RocketDetailViewModel,
    id: String,
    onNavigateBack: () -> Unit,
) {
    val rocketDetailState: RocketDetailState by viewModel.rocketDetail.collectAsState()
    viewModel.getRocketDetail(id)

    Scaffold(
        topBar = { TopBar(rocketDetailState.name, onNavigateBack) },
    ) {
        RocketDetail(rocketDetailState)
    }
}
