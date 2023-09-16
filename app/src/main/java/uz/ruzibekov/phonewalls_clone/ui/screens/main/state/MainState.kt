package uz.ruzibekov.phonewalls_clone.ui.screens.main.state

import uz.ruzibekov.phonewalls_clone.data.model.WallpaperResponse

data class MainState(
    val isLoading: Boolean = false,
    val wallpapers: List<WallpaperResponse> = emptyList(),
    val favorites: List<String> = emptyList(),
    val error: String = "",
)