package uz.ruzibekov.phonewalls_clone.ui.screens.main.state

sealed class MainNavigation {

    class Details(val url: String) : MainNavigation()

    object Settings : MainNavigation()
}