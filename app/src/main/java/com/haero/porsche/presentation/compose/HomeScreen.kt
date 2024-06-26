package com.haero.porsche.presentation.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
        MainBanner(userName = name, dreamCar = "911")
        Spacer(modifier = Modifier.height(8.dp))
        val pageList = listOf(
            ArticleBannerEntity(
                "포르쉐가 SUV를?",
                "세간의 비판을 뚫고 등장한 게임 체인저",
                "https://pmepress.porsche.com/prod/presse_pag/PressResources.nsf/jumppage/modelle-e3ll-cayenne_gts/\$file/e3ll_gts_suv_2024.jpg"
            ),
            ArticleBannerEntity(
                "911, 포르쉐의 자존심",
                "포르쉐의 헤리티지와도 같은 911 알아보기",
                "https://pmepress.porsche.com/download/prod/presse_pag/PressBasicData.nsf/Download?OpenAgent&attachmentid=1913354&show=1"
            ),
            ArticleBannerEntity(
                "보법부터 다른 엔트리 모델",
                "감히 엔트리라 칭할 수 있을까에 대하여",
                "https://pmepress.porsche.com/prod/presse_pag/PressResources.nsf/jumppage/modelle-cayman-cayman_gts_40/\$file/2020-718-cayman-gts_40.jpg"
            )
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
            beyondBoundsPageCount = pageList.size,
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 8.dp)
                .clip(shape = RoundedCornerShape(16.dp))
        ) {
            ArticleBanner(
                pageList[it].title,
                pageList[it].subTitle,
                pageList[it].imageUrl,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        BannerIndicator(pagerState)

        val postList = listOf(
            CommunityPost("오늘도 라면 먹었습니다! (생일이라 계란 2개 풀었음)"),
            CommunityPost("앞으로 34년만 더 저축하면 911 살 수 있네요"),
            CommunityPost("아침에 실수로 포르쉐 박았어요.. 전 911 그렀을까요?")
        )
        CommunityBanner(modifier = Modifier.padding(24.dp), postList)
        CatalogBanner()
    }
}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    PorscheTheme {
        HomeScreen("해로")
    }
}