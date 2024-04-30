package com.haero.porsche.presentation.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun ArticleBanner(
    title: String,
    subTitle: String,
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp),
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "BannerImage",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .drawWithContent {
                    val colors = listOf(
                        Color.Black,
                        Color.Transparent
                    )
                    drawContent()
                    drawRect(
                        brush = Brush.verticalGradient(colors),
                        blendMode = BlendMode.DstIn
                    )
                }
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

data class ArticleBannerEntity(
    val title: String,
    val subTitle: String,
    val imageUrl: String
)