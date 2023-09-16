package uz.ruzibekov.phonewalls_clone.ui.screens.main.state

import uz.ruzibekov.phonewalls_clone.data.model.WallpaperResponse

sealed class MainIntent {

    object FetchImages : MainIntent()

    class OpenDetails(val data: WallpaperResponse) : MainIntent()

    object OpenSettings : MainIntent()

    class AddFavorite(val id: String) : MainIntent()

    class RemoveFavorite(val id: String) : MainIntent()
}