package uz.ruzibekov.phonewalls_clone.ui.screens.main.state

import uz.ruzibekov.phonewalls_clone.data.model.CatImageResponse

sealed class MainUIState {

    object Loading : MainUIState()

    class ImagesLoaded(val list: List<CatImageResponse>) : MainUIState()

    class Error(val message: String?) : MainUIState()
}