package uz.ruzibekov.phonewalls_clone.ui.screens.main._components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.phonewalls_clone.R
import uz.ruzibekov.phonewalls_clone.ui.theme.PhoneWallsIcons

object MainTopBarView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default() {

        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.app_name))
            },
            actions = {

                Item()

                Item()
            }
        )
    }

    @Composable
    private fun Item() {

        IconButton(onClick = { /*TODO*/ }) {

            Icon(
                painter = painterResource(id = PhoneWallsIcons.Unfavorite),
                contentDescription = "icon",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}