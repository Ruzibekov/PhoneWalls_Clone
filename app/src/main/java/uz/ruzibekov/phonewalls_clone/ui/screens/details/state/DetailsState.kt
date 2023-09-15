package uz.ruzibekov.phonewalls_clone.ui.screens.details.state

sealed class DetailsState {

    object Default : DetailsState()

    class ShowImage(val url: String = "") : DetailsState()
}