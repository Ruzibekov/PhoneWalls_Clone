package uz.ruzibekov.phonewalls_clone.ui.screens.main._content

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import uz.ruzibekov.phonewalls_clone.ui.screens.main._components.MainTopBarView
import uz.ruzibekov.phonewalls_clone.ui.screens.main.graph.MainNavGraph

object MainContentView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default() {

        Scaffold(
            topBar = {
                MainTopBarView.Default()
            }

        ) { paddingValues ->

            MainNavGraph.Default(modifier = Modifier.padding(paddingValues))
        }
    }
}