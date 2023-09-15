package uz.ruzibekov.phonewalls_clone.ui.screens.main.state

sealed class MainIntent {

    object FetchImages : MainIntent()

    class OpenDetails(val url: String) : MainIntent()

    object OpenSettings : MainIntent()
}