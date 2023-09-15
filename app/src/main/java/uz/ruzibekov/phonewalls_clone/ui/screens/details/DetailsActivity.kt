package uz.ruzibekov.phonewalls_clone.ui.screens.details

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import uz.ruzibekov.phonewalls_clone.ui.screens.base.BaseActivity
import uz.ruzibekov.phonewalls_clone.ui.screens.details._content.DetailsContentView
import uz.ruzibekov.phonewalls_clone.utils.ExtraConstants

class DetailsActivity : BaseActivity() {

    private val viewModel: DetailsViewModel by viewModels()

    override val content: @Composable () -> Unit = {
        DetailsContentView.Default(viewModel)
    }

    override fun initialize() {
        val url = intent.getStringExtra(ExtraConstants.URL)
        viewModel.setImageUrl(url ?: "")
    }
}