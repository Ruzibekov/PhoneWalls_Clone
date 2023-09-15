package uz.ruzibekov.phonewalls_clone.ui.screens.main.graph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.ruzibekov.phonewalls_clone.ui.screens.main.MainViewModel
import uz.ruzibekov.phonewalls_clone.ui.screens.main._fragments.FavoriteFragmentView
import uz.ruzibekov.phonewalls_clone.ui.screens.main._fragments.HomeFragmentView

object MainNavGraph {

    @Composable
    fun Default(
        modifier: Modifier = Modifier,
        viewModel: MainViewModel,
        navController: NavHostController
    ) {

        NavHost(
            navController = navController,
            startDestination = MainRoutes.HOME_SCREEN,
            modifier = modifier.fillMaxSize()
        ) {

            composable(MainRoutes.HOME_SCREEN) {
                HomeFragmentView.Default(viewModel)
            }

            composable(MainRoutes.FAVORITES_SCREEN) {
                FavoriteFragmentView.Default(viewModel)
            }
        }
    }
}