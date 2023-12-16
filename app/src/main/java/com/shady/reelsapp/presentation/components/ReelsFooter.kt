package com.shady.reelsapp.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shady.reelsapp.presentation.model.ClipPresentationModel

@Composable
fun ReelsFooter(reel: ClipPresentationModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 18.dp, bottom = 18.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        FooterUserData(
            reel = reel, modifier = Modifier.weight(8f)
        )
        FooterUserActions(
            reel = reel, modifier = Modifier.weight(8f)
        )
    }
}