package uz.ruzibekov.phonewalls_clone.ui.screens.details.state

import uz.ruzibekov.phonewalls_clone.data.model.WallpaperResponse

sealed class DetailsState {

    object Default : DetailsState()

    class ShowImage(val data: WallpaperResponse) : DetailsState()
}