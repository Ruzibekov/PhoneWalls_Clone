package uz.ruzibekov.phonewalls_clone.ui.screens.main

import android.content.Intent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.ruzibekov.phonewalls_clone.ui.screens.base.BaseActivity
import uz.ruzibekov.phonewalls_clone.ui.screens.details.DetailsActivity
import uz.ruzibekov.phonewalls_clone.ui.screens.main._content.MainContentView
import uz.ruzibekov.phonewalls_clone.ui.screens.main.event.MainEvents

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()

    override val content: @Composable () -> Unit = {
        MainContentView.Default(viewModel = viewModel)
    }

    override fun initialize() {
        viewModel.fetch()
        initObservers()
    }

    private fun initObservers() {
        viewModel.eventSharedFlow
            .onEach {
                when (it) {
                    is MainEvents.OpenImageDetails -> openImageDetailsScreen()
                }
            }
            .launchIn(lifecycleScope)
    }

    private fun openImageDetailsScreen() {
        val intent = Intent(this, DetailsActivity::class.java)
        startActivity(intent)
    }
}