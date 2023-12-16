package com.shady.reelsapp.ui.model

sealed class ReelsIntent {
    data object GetReels : ReelsIntent()
}