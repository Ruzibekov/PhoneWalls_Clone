package uz.ruzibekov.phonewalls_clone.ui.screens.main._content

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import uz.ruzibekov.phonewalls_clone.ui.screens.main.MainViewModel
import uz.ruzibekov.phonewalls_clone.ui.screens.main._components.MainBottomBarView
import uz.ruzibekov.phonewalls_clone.ui.screens.main._components.MainTopBarView
import uz.ruzibekov.phonewalls_clone.ui.screens.main.graph.MainNavGraph

object MainContentView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(viewModel: MainViewModel) {

        val navController = rememberNavController()

        Scaffold(
            topBar = {
                MainTopBarView.Default(viewModel)
            },

            bottomBar = {
                MainBottomBarView.Default(navController)
            }
        ) { paddingValues ->

            MainNavGraph.Default(
                modifier = Modifier.padding(paddingValues),
                viewModel = viewModel,
                navController = navController
            )
        }
    }
}