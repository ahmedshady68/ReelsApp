package com.shady.reelsapp.ui.reels

import android.widget.FrameLayout
import android.widget.ListPopupWindow.MATCH_PARENT
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.StyledPlayerView

@Composable
fun VideoPlayer(url: String) {
    val context = LocalContext.current
    val exoPlayer = ExoPlayer.Builder(context) // check the new version
        .build()
        .also { exoPlayer ->
            val mediaItem = MediaItem.Builder()
                .setUri(url)
                .build()
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.playWhenReady = true
            exoPlayer.repeatMode = Player.REPEAT_MODE_ALL
            exoPlayer.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
            exoPlayer.prepare()
        }


    DisposableEffect(
        AndroidView(factory = {
            StyledPlayerView(context).apply {  // check the new version
                useController = false
                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                player = exoPlayer
                layoutParams = FrameLayout.LayoutParams(
                    MATCH_PARENT, MATCH_PARENT
                )
            }
        })
    ) {
        onDispose { exoPlayer.release() }
    }

}