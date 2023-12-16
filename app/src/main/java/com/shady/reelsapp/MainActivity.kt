package com.shady.reelsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.shady.reelsapp.presentation.components.ReelsAppPreview
import com.shady.reelsapp.presentation.model.ReelsIntent
import com.shady.reelsapp.presentation.screens.ReelsApp
import com.shady.reelsapp.ui.theme.ReelsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val reelsViewModel: ReelsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sendIntent()
        setContent {
            ReelsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    ReelsApp(
                        reelsList = reelsViewModel.reels.collectAsState().value,
                        retryOnClick = ::sendIntent
                    )
                }
            }
        }
    }

    private fun sendIntent() {
        lifecycleScope.launch {
            reelsViewModel.intentChannel.send(ReelsIntent.GetReels)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ReelsAppTheme {
        ReelsAppPreview()
    }
}
