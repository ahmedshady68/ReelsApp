package com.shady.reelsapp.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shady.reelsapp.presentation.components.ReelsList
import com.shady.reelsapp.presentation.model.ReelsViewState

@Composable
fun ReelsScreen(reelsList: ReelsViewState?) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues = paddingValues)) {
            Box {
                ReelsList(reelsList = reelsList)
            }
        }
    }
}
