package uz.ruzibekov.phonewalls_clone.ui.screens.main._fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import uz.ruzibekov.phonewalls_clone.data.model.ImageResponse
import uz.ruzibekov.phonewalls_clone.ui.components.LoadingView
import uz.ruzibekov.phonewalls_clone.ui.screens.main.MainViewModel
import uz.ruzibekov.phonewalls_clone.ui.screens.main.state.MainIntent
import uz.ruzibekov.phonewalls_clone.ui.screens.main.state.MainState
import uz.ruzibekov.phonewalls_clone.ui.theme.Brushes
import uz.ruzibekov.phonewalls_clone.ui.theme.PhoneWallsColors
import uz.ruzibekov.phonewalls_clone.ui.theme.PhoneWallsIcons

object HomeFragmentView {

    @Composable
    fun Default(viewModel: MainViewModel) {

        val state by viewModel.state.collectAsState()

        when (state) {
            is MainState.Loading -> LoadingView.Default()

            is MainState.Images -> Content(
                list = (state as MainState.Images).list,
                onClick = {
                    viewModel.handleIntent(MainIntent.OpenDetails(it))
                }
            )

            is MainState.Error -> Text(text = "error")
        }
    }

    @Composable
    private fun Content(
        list: List<ImageResponse>,
        onClick: (url: String) -> Unit
    ) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            contentPadding = PaddingValues(2.5.dp)
        ) {

            items(list) { image ->

                Item(
                    data = image,
                    onClick = onClick
                )
            }
        }
    }

    @Composable
    private fun Item(
        data: ImageResponse,
        onClick: (url: String) -> Unit
    ) {

        Box(
            modifier = Modifier
                .padding(2.5.dp)
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable { onClick(data.url) },
            contentAlignment = Alignment.BottomEnd
        ) {

            AsyncImage(
                model = data.url,
                contentDescription = "cat image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Brushes.Dark_Transparent)
            )

                IconButton(onClick = { /*TODO*/ }) {

                    Icon(
                        painter = painterResource(id = PhoneWallsIcons.UnFavorite),
                        contentDescription = "favorite icon",
                        modifier = Modifier.size(24.dp),
                        tint = PhoneWallsColors.White
                    )
                }
        }
    }
}