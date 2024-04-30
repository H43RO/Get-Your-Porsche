package com.haero.porsche.presentation.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CommunityBanner(
    modifier: Modifier = Modifier,
    itemList: List<CommunityPost>
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth()
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    fontSize = 18.sp,
                    text = "포르쉐를 향한 여정",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    fontSize = 14.sp,
                    text = "전체보기",
                    color = Color.LightGray
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            PostDivider()
        }
        items(itemList) {
            CommunityPostItem(it)
            PostDivider()
        }
    }
}

@Composable
private fun CommunityPostItem(
    item: CommunityPost
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(16.dp))
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 4.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = item.title,
                    fontSize = 14.sp,
                    color = Color.Gray
                )

            }
        }
    }
}

@Composable
private fun PostDivider() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.LightGray)
    )
}

data class CommunityPost(
    val title: String
)