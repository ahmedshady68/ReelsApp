package com.shady.reelsapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shady.reelsapp.R
import com.shady.reelsapp.ui.model.ClipPresentationModel


@Composable
fun FooterUserActions(reel: ClipPresentationModel, modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(end = 12.dp)
    ) {
        UserActionWithText(
            drawableRes = R.drawable.ic_favorite_border,
            text = reel.reelLikeCount,
            iconColor = Color.White
        )

        Spacer(modifier = Modifier.height(20.dp))

        UserActionWithText(
            drawableRes = R.drawable.ic_send,
            text = reel.reelShareCount,
            iconColor = Color.White
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}