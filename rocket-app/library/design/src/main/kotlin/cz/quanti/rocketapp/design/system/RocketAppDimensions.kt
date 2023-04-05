package cz.quanti.rocketapp.design.system

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class RocketAppDimensions(
    val sidePadding: Dp,
    val smallSpacer: Dp,
    val mediumSpacer: Dp,
    val bigSpacer: Dp,
    val roundCorners: Dp,
    val titleTopPadding: Dp,
    val iconSize: Dp,
    val elevation: Dp,
    val paramCardSize: Dp,
)
val rocketAppDimensions = RocketAppDimensions(
    sidePadding = 15.dp,
    smallSpacer = 4.dp,
    mediumSpacer = 10.dp,
    bigSpacer = 20.dp,
    roundCorners = 20.dp,
    titleTopPadding = 40.dp,
    iconSize = 30.dp,
    elevation = 5.dp,
    paramCardSize = 110.dp,
)
