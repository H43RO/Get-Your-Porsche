package com.haero.porsche.presentation.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannerIndicator(
    state: PagerState,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        repeat(state.pageCount) {
            Box(
                modifier = Modifier
                    .size(5.dp)
                    .background(
                        color = if (it == state.currentPage) Color.LightGray else Color.White,
                        shape = CircleShape
                    )
                    .clip(CircleShape)
                    .border(
                        width = (0.5).dp,
                        color = Color.LightGray,
                        shape = CircleShape
                    )
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}