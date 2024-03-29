package com.shady.reelsapp.presentation.components

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
import com.shady.reelsapp.presentation.model.ClipPresentationModel


@Composable
fun FooterUserActions(reel: ClipPresentationModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(start = 20.dp, end = 20.dp)
    ) {
        UserActionWithText(
            drawableRes = R.drawable.ic_favorite,
            text = reel.reelLikeCount,
            iconColor = Color.White
        )

        Spacer(modifier = Modifier.height(20.dp))

        UserActionWithText(
            drawableRes = R.drawable.ic_share,
            text = reel.reelShareCount,
            iconColor = Color.White
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}