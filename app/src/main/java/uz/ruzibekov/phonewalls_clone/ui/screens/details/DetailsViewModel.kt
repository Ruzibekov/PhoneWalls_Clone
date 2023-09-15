package uz.ruzibekov.phonewalls_clone.ui.screens.details

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import uz.ruzibekov.phonewalls_clone.ui.screens.details.state.DetailsState

class DetailsViewModel : ViewModel() {

    private val _state: MutableStateFlow<DetailsState> = MutableStateFlow(DetailsState.Default)
    val state: StateFlow<DetailsState> get() = _state

    fun setImageUrl(url: String) {
        if (url.isNotEmpty())
            _state.value = DetailsState.ShowImage(url)
    }
}