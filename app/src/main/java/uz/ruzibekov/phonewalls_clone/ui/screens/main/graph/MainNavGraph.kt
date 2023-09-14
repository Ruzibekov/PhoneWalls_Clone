package uz.ruzibekov.phonewalls_clone.ui.screens.main.graph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uz.ruzibekov.phonewalls_clone.ui.screens.main.MainViewModel
import uz.ruzibekov.phonewalls_clone.ui.screens.main._fragments.AllWallpapersFragmentView

object MainNavGraph {

    @Composable
    fun Default(
        modifier: Modifier = Modifier,
        viewModel: MainViewModel
    ) {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = MainRoutes.EVERYONE_SCREEN,
            modifier = modifier.fillMaxSize()
        ) {

            composable(MainRoutes.EVERYONE_SCREEN) { AllWallpapersFragmentView.Default(viewModel) }
        }
    }
}