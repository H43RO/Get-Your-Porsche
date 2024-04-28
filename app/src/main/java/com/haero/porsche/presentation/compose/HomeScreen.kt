package com.haero.porsche.presentation.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.haero.porsche.presentation.theme.PorscheTheme
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    name: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MainBanner(name)
        Spacer(modifier = Modifier.height(8.dp))
        val pageList = listOf(
            ArticleBannerEntity(
                "911, 포르쉐의 자존심",
                "포르쉐의 헤리티지와도 같은 911 알아보기",
                "https://di-uploads-pod29.dealerinspire.com/porscheontario1/uploads/2023/10/2024-Porsche-911.png"
            ),
            ArticleBannerEntity(
                "포르쉐가 SUV를?",
                "세간의 비판을 뚫고 등장한 게임 체인저",
                "https://presskit.porsche.de/models/assets/images/0/CayenneFVA_Slider_02_Kurzf-ed59bc20.jpg"
            ),
        )
        val pagerState = rememberPagerState(pageCount = { pageList.size })
        LaunchedEffect(key1 = Unit) {
            while (true) {
                delay(3_000L)
                pagerState.animateScrollToPage(if (pagerState.currentPage == pageList.size - 1) 0 else pagerState.currentPage + 1)
            }
        }
        HorizontalPager(
            state = pagerState,
            beyondBoundsPageCount = pageList.size
        ) {
            ArticleBanner(
                pageList[it].title,
                pageList[it].subTitle,
                pageList[it].imageUrl,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        BannerIndicator(pagerState)
    }
}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    PorscheTheme {
        HomeScreen("해로")
    }
}