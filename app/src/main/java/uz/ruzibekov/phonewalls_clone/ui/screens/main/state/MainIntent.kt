package uz.ruzibekov.phonewalls_clone.ui.screens.main.state

sealed class MainIntent {

    object FetchImages : MainIntent()

    class OpenDetailsScreen(val url: String) : MainIntent()
}