package uz.ruzibekov.phonewalls_clone.ui.screens.main._components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import uz.ruzibekov.phonewalls_clone.R
import uz.ruzibekov.phonewalls_clone.ui.screens.main.graph.MainRoutes
import uz.ruzibekov.phonewalls_clone.ui.theme.PhoneWallsIcons

object MainBottomBarView {

    @Composable
    fun Default(navController: NavHostController) {
        val route = navController.getCurrentRoute()

        BottomAppBar {

            Item(
                selected = route == MainRoutes.HOME_SCREEN,
                icon = PhoneWallsIcons.Home,
                textRes = R.string.home
            ) {
                navController.navigate(MainRoutes.HOME_SCREEN)
            }

            Item(
                selected = route == MainRoutes.FAVORITES_SCREEN,
                icon = PhoneWallsIcons.Favorite,
                textRes = R.string.favorite
            ) {
                navController.navigate(MainRoutes.FAVORITES_SCREEN)
            }
        }
    }

    @Composable
    fun RowScope.Item(
        selected: Boolean,
        icon: Int,
        textRes: Int,
        onClick: () -> Unit
    ) {

        NavigationBarItem(
            selected = selected,
            onClick = onClick,
            icon = {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = "icon",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    text = stringResource(id = textRes),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        )
    }

    @Composable
    private fun NavHostController.getCurrentRoute(): String {
        val navBackStackEntry by currentBackStackEntryAsState()
        return navBackStackEntry?.destination?.route ?: MainRoutes.HOME_SCREEN
    }
}