package com.haero.porsche.presentation.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haero.porsche.R
import com.haero.porsche.presentation.theme.PorscheRed
import com.haero.porsche.presentation.theme.PorscheYellow

@Composable
fun MainBanner(
    userName: String
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
                text = "${userName}님 반갑습니다"
            )
        }
    }
}
