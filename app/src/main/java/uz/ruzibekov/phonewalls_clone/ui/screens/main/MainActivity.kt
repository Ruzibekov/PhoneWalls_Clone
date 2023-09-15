package uz.ruzibekov.phonewalls_clone.ui.screens.main

import android.content.Intent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.ruzibekov.phonewalls_clone.ui.screens.base.BaseActivity
import uz.ruzibekov.phonewalls_clone.ui.screens.details.DetailsActivity
import uz.ruzibekov.phonewalls_clone.ui.screens.main._content.MainContentView
import uz.ruzibekov.phonewalls_clone.ui.screens.main.state.MainEffect
import uz.ruzibekov.phonewalls_clone.ui.screens.main.state.MainIntent
import uz.ruzibekov.phonewalls_clone.utils.ExtraConstants

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()

    override val content: @Composable () -> Unit = {
        MainContentView.Default(viewModel = viewModel)
    }

    override fun initialize() {

        lifecycleScope.launch {
            viewModel.intent.send(MainIntent.FetchImages)
        }

        viewModel.effects
            .onEach { effect ->
                when (effect) {
                    is MainEffect.OpenDetails -> openImageDetailsScreen(effect.url)
                }
            }
            .launchIn(lifecycleScope)
    }

    private fun openImageDetailsScreen(url: String) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(ExtraConstants.URL, url)
        startActivity(intent)
    }
}