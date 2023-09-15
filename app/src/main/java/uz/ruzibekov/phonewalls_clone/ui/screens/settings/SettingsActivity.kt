package uz.ruzibekov.phonewalls_clone.ui.screens.settings

import androidx.compose.runtime.Composable
import uz.ruzibekov.phonewalls_clone.ui.screens.base.BaseActivity
import uz.ruzibekov.phonewalls_clone.ui.screens.settings._content.SettingsContentView

class SettingsActivity : BaseActivity() {

    override val content: @Composable () -> Unit = {
        SettingsContentView.Default()
    }

    override fun initialize() {}
}