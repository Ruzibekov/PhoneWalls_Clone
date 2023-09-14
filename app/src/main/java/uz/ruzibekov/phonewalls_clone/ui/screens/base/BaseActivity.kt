package uz.ruzibekov.phonewalls_clone.ui.screens.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import uz.ruzibekov.phonewalls_clone.ui.theme.PhoneWalls_CloneTheme

abstract class BaseActivity : ComponentActivity() {

    abstract val content: @Composable () -> Unit

    abstract fun initialize()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PhoneWalls_CloneTheme {
                content()
            }
        }

        initialize()
    }
}