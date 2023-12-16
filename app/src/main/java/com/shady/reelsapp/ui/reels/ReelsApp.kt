package com.shady.reelsapp.ui.reels

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.shady.reelsapp.ui.model.ReelsViewState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReelsApp(reelsList: ReelsViewState?) {
    Box {
        ReelsScreen(reelsList = reelsList)
        TopAppBar(
            title = {
                Text(
                    reelsList
                        ?.reelsPresentationModel?.reelsMainTitle.toString(),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }, colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent.copy(alpha = 0.0f)
            )
        )
    }
}
