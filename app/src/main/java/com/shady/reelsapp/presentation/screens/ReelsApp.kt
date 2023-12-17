package com.shady.reelsapp.presentation.screens

import androidx.compose.runtime.Composable
import com.shady.reelsapp.presentation.model.ReelsViewState

@Composable
fun ReelsApp(reelsList: ReelsViewState?, retryOnClick: () -> Unit) {
    reelsList?.isLoading.also { showLoading ->
        ReelsLoadingScreen(showLoading)
    }
    reelsList?.reelsPresentationModel?.let {
        ReelsSuccessScreen(state = reelsList)
    }
    reelsList?.error?.let {
        ReelsErrorScreen(retryOnClick = retryOnClick)
    }
}
