package uz.ruzibekov.phonewalls_clone.ui.screens.details

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.ruzibekov.phonewalls_clone.data.model.WallpaperResponse
import uz.ruzibekov.phonewalls_clone.ui.screens.base.BaseActivity
import uz.ruzibekov.phonewalls_clone.ui.screens.details._content.DetailsContentView
import uz.ruzibekov.phonewalls_clone.ui.screens.details.state.DetailsNavigation
import uz.ruzibekov.phonewalls_clone.utils.ExtraConstants

@AndroidEntryPoint
class DetailsActivity : BaseActivity() {

    private val viewModel: DetailsViewModel by viewModels()

    override val content: @Composable () -> Unit = {
        DetailsContentView.Default(viewModel)
    }

    override fun initialize() {
        fetch()
        initNavigation()
    }

    private fun fetch() {
        intent.getStringExtra(ExtraConstants.Data)?.let { json ->
            val data = Gson().fromJson(json, WallpaperResponse::class.java)
            viewModel.loadData(data)
        }
    }

    private fun initNavigation() {
        viewModel.navigation
            .onEach {
                when (it) {
                    is DetailsNavigation.OnBackStack -> finish()
                }
            }
            .launchIn(lifecycleScope)
    }
}