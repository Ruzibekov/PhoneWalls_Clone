package uz.ruzibekov.phonewalls_clone.ui.screens.details.state

sealed class DetailsIntent {

    object OnBackStack : DetailsIntent()

    object DownloadImage : DetailsIntent()

    object SetWallpaper : DetailsIntent()

    object RemoveFromFavorites : DetailsIntent()

    object AddToFavorites : DetailsIntent()
}
