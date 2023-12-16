package com.shady.reelsapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shady.reelsapp.ui.model.ClipPresentationModel

@Composable
fun ReelsFooter(reel: ClipPresentationModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 18.dp, bottom = 18.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = reel.reelTitle,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(8f)
        )

        FooterUserActions(
            reel = reel,
            modifier = Modifier.weight(8f)
        )
    }
}