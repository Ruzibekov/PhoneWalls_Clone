package uz.ruzibekov.phonewalls_clone.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.ruzibekov.phonewalls_clone.data.api.ApiService
import uz.ruzibekov.phonewalls_clone.ui.screens.main.event.MainEvents
import uz.ruzibekov.phonewalls_clone.ui.screens.main.state.MainUIState
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val service: ApiService
) : ViewModel() {

    private val _state: MutableStateFlow<MainUIState> = MutableStateFlow(MainUIState.Loading)
    val state: StateFlow<MainUIState> get() = _state

    val eventSharedFlow: MutableSharedFlow<MainEvents> = MutableSharedFlow()

    fun fetch() = viewModelScope.launch {
        _state.value = MainUIState.Loading

        try {

            val list = service.getCatsImageList()
            _state.value = MainUIState.ImagesLoaded(list)
        } catch (e: Exception) {

            _state.value = MainUIState.Error(message = e.message)
        }
    }

    fun send(event: MainEvents.OpenImageDetails) = viewModelScope.launch {
        eventSharedFlow.emit(event)
    }
}