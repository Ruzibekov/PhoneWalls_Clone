package uz.ruzibekov.phonewalls_clone.ui.screens.main._fragments

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import uz.ruzibekov.phonewalls_clone.ui.components.LoadingView
import uz.ruzibekov.phonewalls_clone.ui.screens.main.MainViewModel

object FavoriteFragmentView {

    @Composable
    fun Default(viewModel: MainViewModel) {

        val state by viewModel.state.collectAsState()

        when {

            state.isLoading -> LoadingView.Default()

            state.error.isNotEmpty() -> Text(text = "error")

            else -> Content(viewModel = viewModel)
        }
    }

    @Composable
    private fun Content(viewModel: MainViewModel) {
        
        Text(text = viewModel.state.value.favorites.size.toString())
    }
}