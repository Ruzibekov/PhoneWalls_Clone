package uz.ruzibekov.phonewalls_clone.ui.screens.main._fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.phonewalls_clone.R
import uz.ruzibekov.phonewalls_clone.ui.theme.Brushes
import uz.ruzibekov.phonewalls_clone.ui.theme.PhoneWallsColors
import uz.ruzibekov.phonewalls_clone.ui.theme.PhoneWallsIcons

object AllWallpapersFragmentView {

    @Composable
    fun Default() {

        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            contentPadding = PaddingValues(2.5.dp)
        ) {

            items(10) {

                Item()
            }
        }
    }

    @Composable
    fun Item() {

        Box(
            modifier = Modifier
                .padding(2.5.dp)
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.BottomCenter
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "wallpaper image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Brushes.Dark_Transparent)
            )

            Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(modifier = Modifier.weight(1f)) {

                    Text(
                        text = "Title",
                        style = MaterialTheme.typography.titleMedium,
                        color = PhoneWallsColors.White
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Phone model",
                        color = PhoneWallsColors.White
                    )
                }

                IconButton(onClick = { /*TODO*/ }) {

                    Icon(
                        painter = painterResource(id = PhoneWallsIcons.Unfavorite),
                        contentDescription = "favorite icon",
                        modifier = Modifier.size(24.dp),
                        tint = PhoneWallsColors.White
                    )
                }
            }
        }
    }
}