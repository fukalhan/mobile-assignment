package cz.quanti.rocketapp.rocketdetail.system

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import cz.quanti.rocketapp.design.system.RocketAppTheme
import cz.quanti.rocketapp.rocketdetail.R

@Composable
fun Photos(urls: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        if (urls.isNotEmpty()) {
            Text(
                text = stringResource(id = R.string.photos),
                style = RocketAppTheme.typography.title,
                color = RocketAppTheme.colors.textPrimary
            )

            Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.mediumSpacer))
            urls.forEach {
                Photo(url = it)
                Spacer(modifier = Modifier.height(RocketAppTheme.dimensions.mediumSpacer))
            }
        }
    }
}

@Composable
fun Photo(url: String) {
    AsyncImage(
        model = url,
        contentDescription = "Rocket photo",
        modifier = Modifier
            .clip(RoundedCornerShape(RocketAppTheme.dimensions.roundCorners))
            .fillMaxWidth()
            .wrapContentHeight(),
        contentScale = ContentScale.FillWidth
    )
}
