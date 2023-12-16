package com.shady.reelsapp.ui.model

data class ReelsViewState(
    val reelsPresentationModel: ReelsPresentationModel? = null,
    val isLoading: Boolean = false,
    val error: Throwable? = null,
)
