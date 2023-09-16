package uz.ruzibekov.phonewalls_clone.ui.screens.main._components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import uz.ruzibekov.phonewalls_clone.R
import uz.ruzibekov.phonewalls_clone.ui.screens.main.MainViewModel
import uz.ruzibekov.phonewalls_clone.ui.screens.main.state.MainIntent

object MainTopBarView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(viewModel: MainViewModel) {

        var showMenu by remember { mutableStateOf(false) }

        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.bodyMedium
                )
            },
            actions = {

                IconButton(onClick = { showMenu = !showMenu }) {
                    Icon(Icons.Default.MoreVert, "")
                }

                DropdownMenu(
                    expanded = showMenu,
                    onDismissRequest = { showMenu = false }
                ) {

                    DropdownMenuItem(
                        text = {
                            Text(
                                text = stringResource(id = R.string.settings),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        },
                        onClick = {
                            viewModel.send(MainIntent.OpenSettings)
                        },
                    )
                }
            }
        )
    }
}