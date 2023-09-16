package uz.ruzibekov.phonewalls_clone.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.ruzibekov.phonewalls_clone.data.LocalManager
import uz.ruzibekov.phonewalls_clone.data.api.ApiService
import uz.ruzibekov.phonewalls_clone.ui.screens.main.state.MainIntent
import uz.ruzibekov.phonewalls_clone.ui.screens.main.state.MainNavigation
import uz.ruzibekov.phonewalls_clone.ui.screens.main.state.MainState
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val service: ApiService,
    private val localManager: LocalManager
) : ViewModel() {

    private val _state: MutableStateFlow<MainState> = MutableStateFlow(MainState(isLoading = true))
    val state: StateFlow<MainState> get() = _state

    val navigation: MutableSharedFlow<MainNavigation> = MutableSharedFlow()

    fun send(intent: MainIntent) = viewModelScope.launch {
        when (intent) {
            is MainIntent.FetchImages -> fetch()

            is MainIntent.OpenDetails -> navigation.emit(MainNavigation.Details(intent.data))

            is MainIntent.OpenSettings -> navigation.emit(MainNavigation.Settings)

            is MainIntent.AddFavorite -> addIdToFavorite(intent.id)

            is MainIntent.RemoveFavorite -> removeFavoriteById(intent.id)
        }
    }

    fun checkWallpaperToFavorite(id: String): Boolean {
        return localManager.favorites.contains(id)
    }

    private fun fetch() = viewModelScope.launch {
        _state.value = MainState(isLoading = true)
        try {
            fetchWallpapers()
            fetchFavorites()
        } catch (e: Exception) {
            _state.value = MainState(error = e.message.toString())
        }
    }

    private fun fetchWallpapers() = viewModelScope.launch {
        val list = service.getCatsImageList()
        _state.value = MainState(wallpapers = list)
    }

    private fun fetchFavorites() = viewModelScope.launch {
        val list = localManager.favorites
        if (list.isNotEmpty())
            _state.value = MainState(favorites = list)
    }

    private fun addIdToFavorite(id: String) {
        localManager.favorites = localManager.favorites + id
    }

    private fun removeFavoriteById(id: String) {
        localManager.favorites = localManager.favorites - id
    }
}