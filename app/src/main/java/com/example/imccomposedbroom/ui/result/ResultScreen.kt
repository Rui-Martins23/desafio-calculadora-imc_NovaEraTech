package com.example.imccomposedbroom.ui.result

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.imccomposedbroom.domain.BmiCalculator
import com.example.imccomposedbroom.ui.components.ImcHeader
import com.example.imccomposedbroom.ui.theme.ImcClassification
import com.example.imccomposedbroom.ui.theme.ImcComposeDbRoomTheme
import com.example.imccomposedbroom.ui.theme.ImcLabel
import com.example.imccomposedbroom.ui.theme.ImcScreenBackground

@Composable
fun ResultScreen(
    bmi: Double
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ImcScreenBackground)
    ) {

        ImcHeader(
            description = "Aqui está seu resultado",
            modifier = Modifier.weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = BmiCalculator.format(bmi),
                    color = Color.White,
                    fontSize = 68.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .navigationBarsPadding()
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Classificação",
                    color = ImcLabel,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = BmiCalculator.classify(bmi),
                    color = ImcClassification,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.6.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ResultScreenPreview() {
    ImcComposeDbRoomTheme {
        ResultScreen(bmi = 24.00)
    }
}
