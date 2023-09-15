package uz.ruzibekov.phonewalls_clone.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.ruzibekov.phonewalls_clone.data.api.ApiService
import uz.ruzibekov.phonewalls_clone.ui.screens.main.state.MainIntent
import uz.ruzibekov.phonewalls_clone.ui.screens.main.state.MainNavEffect
import uz.ruzibekov.phonewalls_clone.ui.screens.main.state.MainState
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val service: ApiService
) : ViewModel() {

    private val _state: MutableStateFlow<MainState> = MutableStateFlow(MainState.Loading)
    val state: StateFlow<MainState> get() = _state

    val navigationEffect: MutableSharedFlow<MainNavEffect> = MutableSharedFlow()

    fun handleIntent(intent: MainIntent) = viewModelScope.launch {
        when (intent) {
            is MainIntent.FetchImages -> fetch()

            is MainIntent.OpenDetails -> navigationEffect.emit(MainNavEffect.Details(intent.url))

            is MainIntent.OpenSettings -> navigationEffect.emit(MainNavEffect.Settings)
        }
    }

    private fun fetch() = viewModelScope.launch {
        _state.value = MainState.Loading

        try {
            val list = service.getCatsImageList()
            _state.value = MainState.Images(list)
        } catch (e: Exception) {
            _state.value = MainState.Error(e.message.toString())
        }
    }
}