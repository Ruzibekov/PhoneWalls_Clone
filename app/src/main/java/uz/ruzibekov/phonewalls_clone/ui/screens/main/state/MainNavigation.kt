package uz.ruzibekov.phonewalls_clone.ui.screens.main.state

import uz.ruzibekov.phonewalls_clone.data.model.WallpaperResponse

sealed class MainNavigation {

    class Details(val data: WallpaperResponse) : MainNavigation()

    object Settings : MainNavigation()
}