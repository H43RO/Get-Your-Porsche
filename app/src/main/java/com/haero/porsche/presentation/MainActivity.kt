package com.haero.porsche.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haero.porsche.R
import com.haero.porsche.presentation.theme.PorscheTheme

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
                Text(
                    fontSize = 14.sp,
                    color = Color.LightGray,
                    text = "예비 포르쉐 오너"
                )
                Text(
                    fontSize = 20.sp,
                    color = Color.White,
                    text = "${name}님 반갑습니다"
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "There is no substitute.",
            color = Color.Black,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PorscheTheme {
        GreetingBanner("해로")
    }
}