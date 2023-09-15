package uz.ruzibekov.phonewalls_clone.ui.screens.details._content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import uz.ruzibekov.phonewalls_clone.R
import uz.ruzibekov.phonewalls_clone.ui.components.LoadingView
import uz.ruzibekov.phonewalls_clone.ui.screens.details.DetailsViewModel
import uz.ruzibekov.phonewalls_clone.ui.screens.details.state.DetailsState
import uz.ruzibekov.phonewalls_clone.ui.theme.PhoneWallsColors

object DetailsContentView {

    @Composable
    fun Default(viewModel: DetailsViewModel) {

        val state by viewModel.state.collectAsState()

        when (state) {

            is DetailsState.Default -> LoadingView.Default()

            is DetailsState.ShowImage -> Content((state as DetailsState.ShowImage).url)
        }
    }

    @Composable
    private fun Content(url: String, ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {

            AsyncImage(
                model = url,
                contentDescription = "wallpaper",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .statusBarsPadding()
                    .align(Alignment.TopStart)
            ) {

                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "back arrow icon",
                    tint = PhoneWallsColors.White
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Item(
                    icon = R.drawable.ic_download,
                    textRes = R.string.download
                )

                Item(
                    icon = R.drawable.ic_load,
                    textRes = R.string.set_wallpaper
                )

                Item(
                    icon = R.drawable.ic_unfavorite,
                    textRes = R.string.favorite
                )
            }
        }
    }

    @Composable
    private fun Item(
        icon: Int,
        textRes: Int,
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Icon(
                painter = painterResource(id = icon),
                contentDescription = "icon",
                modifier = Modifier.size(24.dp),
                tint = PhoneWallsColors.White
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = stringResource(id = textRes),
                style = MaterialTheme.typography.bodyMedium,
                color = PhoneWallsColors.White
            )
        }
    }
}