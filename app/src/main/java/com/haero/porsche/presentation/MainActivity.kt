package com.haero.porsche.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.haero.porsche.R
import com.haero.porsche.presentation.theme.PorscheRed
import com.haero.porsche.presentation.theme.PorscheTheme
import com.haero.porsche.presentation.theme.PorscheYellow
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PorscheTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    GreetingBanner("해로")
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GreetingBanner(
    name: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.porsche_logo),
                contentDescription = "logo",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(100.dp)
                    .padding(16.dp)
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomStart)
            ) {
                Row {
                    Text(
                        fontSize = 16.sp,
                        color = PorscheRed,
                        text = "예비"
                    )
                    Text(
                        fontSize = 16.sp,
                        color = PorscheYellow,
                        text = " 포르쉐 오너"
                    )
                }
                Text(
                    fontSize = 24.sp,
                    color = Color.White,
                    text = "${name}님 반갑습니다"
                )
            }
        }
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
            ArticleBannerItem(
                pageList[it].title,
                pageList[it].subTitle,
                pageList[it].imageUrl,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        BannerIndicator(pagerState)
    }
}

data class ArticleBannerEntity(
    val title: String,
    val subTitle: String,
    val imageUrl: String
)

@Composable
fun ArticleBannerItem(
    title: String,
    subTitle: String,
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .background(Color.White)
            .clip(shape = RoundedCornerShape(16.dp)),
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = imageUrl,
            contentDescription = "BannerImage",
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.3F))
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp),
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                color = Color.White
            )
            Text(
                text = subTitle,
                fontSize = 12.sp,
                color = Color.LightGray
            )
        }
    }
}

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
                    .size(10.dp)
                    .background(
                        color = if (it == state.currentPage) Color.LightGray else Color.White,
                        shape = CircleShape
                    )
                    .clip(CircleShape)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = CircleShape
                    )
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PorscheTheme {
        GreetingBanner("해로")
    }
}