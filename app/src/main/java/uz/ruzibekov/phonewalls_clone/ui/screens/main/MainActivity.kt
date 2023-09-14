package uz.ruzibekov.phonewalls_clone.ui.screens.main

import androidx.compose.runtime.Composable
import uz.ruzibekov.phonewalls_clone.ui.screens.base.BaseActivity
import uz.ruzibekov.phonewalls_clone.ui.screens.main._content.MainContentView

class MainActivity : BaseActivity() {

    override val content: @Composable () -> Unit = {
        MainContentView.Default()
    }

    override fun initialize() {

    }
}