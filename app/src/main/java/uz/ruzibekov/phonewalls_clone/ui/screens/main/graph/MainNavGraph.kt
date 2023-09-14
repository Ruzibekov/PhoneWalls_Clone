package uz.ruzibekov.phonewalls_clone.ui.screens.main.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uz.ruzibekov.phonewalls_clone.ui.screens.main._fragments.AllWallpapersFragmentView

object MainNavGraph {

    @Composable
    fun Default(modifier: Modifier) {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = MainRoutes.EVERYONE_SCREEN,
            modifier = modifier
        ) {

            composable(MainRoutes.EVERYONE_SCREEN) { AllWallpapersFragmentView.Default() }
        }
    }
}