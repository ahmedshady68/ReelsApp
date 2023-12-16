package com.shady.reelsapp.presentation.model

data class ReelsViewState(
    val reelsPresentationModel: ReelsPresentationModel? = null,
    val isLoading: Boolean = false,
    val error: Throwable? = null,
)
