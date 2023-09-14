package uz.ruzibekov.phonewalls_clone.ui.screens.main.event

sealed class MainEvents {

    class OpenImageDetails(url: String) : MainEvents()
}