package com.haero.porsche.presentation.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haero.porsche.R
import kotlinx.coroutines.delay

@Composable
fun CatalogBanner(
    modifier: Modifier = Modifier
) {
    var porscheSlideAnim by remember { mutableStateOf(false) }
    var titleAnim by remember { mutableStateOf(false) }
    var subTitleAnim by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = Unit) {
        delay(800L)
        porscheSlideAnim = true
        delay(1000L)
        titleAnim = true
        delay(500L)
        subTitleAnim = true
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        AnimatedVisibility(
            visible = porscheSlideAnim,
            enter = slideInHorizontally(
                initialOffsetX = { -1300 },
                animationSpec = tween(
                    durationMillis = 1000,
                    easing = FastOutSlowInEasing
                )
            ),
        ) {
            Image(
                painter = painterResource(id = R.drawable.porsche_gts),
                contentDescription = "banner_background",
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )
        }
        AnimatedVisibility(
            visible = titleAnim
        ) {
            Text(
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                text = "나만의 포르쉐 만들기"
            )
        }
        AnimatedVisibility(
            visible = subTitleAnim
        ) {
            Text(
                fontSize = 14.sp,
                color = Color.Gray,
                text = "잠시나마 아름다운 순간으로."
            )
        }
    }
}