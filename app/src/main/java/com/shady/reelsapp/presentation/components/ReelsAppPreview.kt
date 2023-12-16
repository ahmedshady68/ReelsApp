package com.shady.reelsapp.presentation.components

import androidx.compose.runtime.Composable
import com.shady.reelsapp.presentation.model.ClipPresentationModel
import com.shady.reelsapp.presentation.model.ReelsPresentationModel
import com.shady.reelsapp.presentation.model.ReelsViewState
import com.shady.reelsapp.presentation.screens.ReelsApp

@Composable
fun ReelsAppPreview() {
    ReelsApp(
        ReelsViewState(
            ReelsPresentationModel(
                listOf(
                    ClipPresentationModel(
                        "reelTitle",
                        "reelLikeCount",
                        "reelShareCount",
                        "reelUrl"
                    )
                ), ""
            ),
            false,
            null
        )
    ) {
        // retry onClick
    }
}