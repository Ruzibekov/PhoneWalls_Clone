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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import uz.ruzibekov.phonewalls_clone.data.model.WallpaperResponse
import uz.ruzibekov.phonewalls_clone.ui.components.LoadingView
import uz.ruzibekov.phonewalls_clone.ui.screens.main.MainViewModel
import uz.ruzibekov.phonewalls_clone.ui.screens.main.state.MainIntent
import uz.ruzibekov.phonewalls_clone.ui.theme.Brushes
import uz.ruzibekov.phonewalls_clone.ui.theme.PhoneWallsColors
import uz.ruzibekov.phonewalls_clone.ui.theme.PhoneWallsIcons

object HomeFragmentView {

    @Composable
    fun Default(viewModel: MainViewModel) {

        val state by viewModel.state.collectAsState()

        when {

            state.isLoading -> LoadingView.Default()

            state.error.isNotEmpty() -> Text(text = "error")

            else -> Content(
                list = state.wallpapers,
                viewModel = viewModel
            )
        }
    }

    @Composable
    private fun Content(
        list: List<WallpaperResponse>,
        viewModel: MainViewModel
    ) {

        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            contentPadding = PaddingValues(2.5.dp)
        ) {

            items(list) { image ->

                Item(
                    data = image,
                    isFavorite = viewModel.checkWallpaperToFavorite(image.id),
                    onClick = {
                        viewModel.send(MainIntent.OpenDetails(it))
                    },
                    addToFavorites = {
                        viewModel.send(MainIntent.AddFavorite(it))
                    },
                    removeFromFavorites = {
                        viewModel.send(MainIntent.RemoveFavorite(it))
                    }
                )
            }
        }
    }

    @Composable
    private fun Item(
        data: WallpaperResponse,
        isFavorite: Boolean,
        onClick: (data: WallpaperResponse) -> Unit,
        addToFavorites: (id: String) -> Unit,
        removeFromFavorites: (id: String) -> Unit
    ) {

        var favorite by remember {
            mutableStateOf(isFavorite)
        }

        Box(
            modifier = Modifier
                .padding(2.5.dp)
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable { onClick(data) },
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

            IconButton(
                onClick = {
                    if (favorite)
                        removeFromFavorites(data.id)
                    else
                        addToFavorites(data.id)

                    favorite = !favorite
                }
            ) {

                Icon(
                    painter = painterResource(
                        id = if (favorite) PhoneWallsIcons.Favorite
                        else PhoneWallsIcons.UnFavorite
                    ),
                    contentDescription = "favorite icon",
                    modifier = Modifier.size(24.dp),
                    tint = PhoneWallsColors.White
                )
            }
        }
    }
}