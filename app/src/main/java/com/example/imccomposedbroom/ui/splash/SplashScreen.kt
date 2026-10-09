package com.example.imccomposedbroom.ui.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.imccomposedbroom.R
import com.example.imccomposedbroom.ui.components.ImcLogo
import com.example.imccomposedbroom.ui.navigation.ImcRoutes
import com.example.imccomposedbroom.ui.theme.ImcComposeDbRoomTheme
import com.example.imccomposedbroom.ui.theme.ImcGradient
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

private const val SPLASH_DURATION_MS = 2000L

@Composable
fun SplashScreen(
    navController: NavController = rememberNavController()
) {
    LaunchedEffect(Unit) {
        delay(SPLASH_DURATION_MS.milliseconds)
        navController.navigate(ImcRoutes.INPUT)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ImcGradient)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            ImcLogo(size = 100.dp)

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.app_title),
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.splash_subtitle),
                color = Color.White.copy(alpha = 0.90f),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            CircularProgressIndicator(
                modifier = Modifier
                    .size(32.dp),
                color = Color.White,
                strokeWidth = 3.dp,
                strokeCap = StrokeCap.Round
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    ImcComposeDbRoomTheme {
        SplashScreen()
    }
}