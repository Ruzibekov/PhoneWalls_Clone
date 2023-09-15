package uz.ruzibekov.phonewalls_clone.ui.screens.main.state

import uz.ruzibekov.phonewalls_clone.data.model.ImageResponse

sealed class MainState {

    object Loading : MainState()

    data class Images(val list: List<ImageResponse>) : MainState()

    data class Error(val message: String) : MainState()
}