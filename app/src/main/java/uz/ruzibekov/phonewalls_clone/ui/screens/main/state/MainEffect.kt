package uz.ruzibekov.phonewalls_clone.ui.screens.main.state

sealed class MainEffect {

    class OpenDetails(val url: String) : MainEffect()
}