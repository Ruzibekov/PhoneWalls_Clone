package uz.ruzibekov.phonewalls_clone.ui.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.ruzibekov.phonewalls_clone.data.LocalManager
import uz.ruzibekov.phonewalls_clone.data.model.WallpaperResponse
import uz.ruzibekov.phonewalls_clone.ui.screens.details.state.DetailsIntent
import uz.ruzibekov.phonewalls_clone.ui.screens.details.state.DetailsNavigation
import uz.ruzibekov.phonewalls_clone.ui.screens.details.state.DetailsState
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val localManager: LocalManager
) : ViewModel() {

    private val _state: MutableStateFlow<DetailsState> = MutableStateFlow(DetailsState.Default)
    val state: StateFlow<DetailsState> get() = _state

    val navigation: MutableSharedFlow<DetailsNavigation> = MutableSharedFlow()

    fun send(intent: DetailsIntent) = viewModelScope.launch {

        when (intent) {

            is DetailsIntent.OnBackStack -> navigation.emit(DetailsNavigation.OnBackStack)

            is DetailsIntent.DownloadImage -> downloadImage()

            is DetailsIntent.SetWallpaper -> setWallpaper()

            is DetailsIntent.RemoveFromFavorites -> removeFromFavorites()

            is DetailsIntent.AddToFavorites -> addToFavorites()
        }
    }

    fun loadData(data: WallpaperResponse) {
        _state.value = DetailsState.ShowImage(data)
    }

    fun checkWallpaperInFavorite(): Boolean {
        val data = (state.value as DetailsState.ShowImage).data
        return localManager.favorites.contains(data.id)
    }

    private fun downloadImage() {
//        TODO("Not yet implemented")
    }

    private fun setWallpaper() {
//        TODO("Not yet implemented")
    }

    private fun removeFromFavorites() {
//        TODO("Not yet implemented")
    }

    private fun addToFavorites() {
//        TODO("Not yet implemented")
    }
}