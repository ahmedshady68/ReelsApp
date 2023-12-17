package com.shady.reelsapp.presentation.model

sealed class ReelsIntent {
    data object GetReels : ReelsIntent()
}