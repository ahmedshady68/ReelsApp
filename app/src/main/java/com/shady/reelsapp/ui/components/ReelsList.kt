package com.shady.reelsapp.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.shady.reelsapp.ui.model.ReelsViewState
import com.shady.reelsapp.ui.reels.VideoPlayer

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReelsList(reelsList: ReelsViewState?) {

    val pageCount = Int.MAX_VALUE
    val pagerState = rememberPagerState(
        initialPage = 0, initialPageOffsetFraction = 0f
    ) {
        pageCount
    }
    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
    ) { index ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            if (reelsList?.reelsPresentationModel?.reelsList == null) {
                return@Box
            } // redesign this area ..
            VideoPlayer(
                url = reelsList.reelsPresentationModel
                    .reelsList[index % reelsList.reelsPresentationModel.reelsList.size].reelUrl
            )
            Column(Modifier.align(Alignment.BottomStart)) {
                ReelsFooter(
                    reelsList.reelsPresentationModel.reelsList[index % reelsList.reelsPresentationModel.reelsList.size]
                )
            }
        }
    }
}
