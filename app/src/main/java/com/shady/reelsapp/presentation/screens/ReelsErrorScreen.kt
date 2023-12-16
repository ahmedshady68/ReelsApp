package com.shady.reelsapp.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.shady.reelsapp.R

@Composable
fun ReelsErrorScreen(retryOnClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(TopCenter)
        ) {
            LottieView(
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = stringResource(R.string.retry_title_text),
                Modifier
                    .padding(top = 25.dp)
                    .fillMaxWidth(),
                color = MaterialTheme.colorScheme.tertiary,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
            Text(
                text = stringResource(R.string.retry_description_text),
                Modifier
                    .padding(top = 13.dp)
                    .fillMaxWidth(),
                color = Color.Gray,
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
        }

        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = BottomCenter)
                .padding(bottom = 50.dp, start = 20.dp, end = 20.dp),
            onClick = {
                retryOnClick.invoke()
            },
            border = BorderStroke(1.dp, Color.Green)
        ) {
            Text(text = stringResource(R.string.retry_button_text), color = Color.Green)
        }
    }
}

@Composable
fun LottieView(modifier: Modifier) {
    Surface(modifier = modifier) {
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.error_screen_animation))
        LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever)
    }
}