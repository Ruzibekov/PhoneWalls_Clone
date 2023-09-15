package uz.ruzibekov.phonewalls_clone.ui.screens.main.state

sealed class MainNavEffect {

    class Details(val url: String) : MainNavEffect()

    object Settings : MainNavEffect()
}