package com.example.imccomposedbroom.ui.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.imccomposedbroom.data.BmiResult
import com.example.imccomposedbroom.ui.components.ImcHeader
import com.example.imccomposedbroom.ui.components.ImcTextField
import com.example.imccomposedbroom.ui.components.SimpleButton
import com.example.imccomposedbroom.ui.navigation.ImcRoutes
import com.example.imccomposedbroom.ui.theme.ImcButton
import com.example.imccomposedbroom.ui.theme.ImcFieldBackground
import com.example.imccomposedbroom.ui.theme.ImcHint
import com.example.imccomposedbroom.ui.theme.ImcScreenBackground
import com.example.imccomposedbroom.ui.theme.ImcText

@Composable
fun InputScreen(
    onCalculated: (BmiResult) -> Unit,
    onHistoryClick: () -> Unit
) {
    var weight by rememberSaveable() { mutableStateOf("") }
    var height by rememberSaveable() { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ImcScreenBackground),
    ) {
        ImcHeader(description = "Realize seu cálculo")

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 24.dp)
                .padding(top = 32.dp)
        ) {
            ImcTextField(
                value = weight,
                onValueChange = { textInput ->
                    weight = textInput
                },
                placeholder = "Digite seu peso",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            ImcTextField(
                value = height,
                onValueChange = { textInput ->
                    height = textInput
                },
                placeholder = "Digite sua altura",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal,
                    imeAction = ImeAction.Next
                )
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SimpleButton(
                text = "Ver Histórico",
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    onHistoryClick()
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    val weightKg = weight.replace(",", ".").toDoubleOrNull()
                    val heightMeters = height.replace(",", ".").toDoubleOrNull()

                    if (weightKg != null && heightMeters != null && heightMeters > 0) {
                        val bmi = weightKg / (heightMeters * heightMeters)

                        val result = BmiResult(
                            weightKg = weightKg,
                            heightMeters = heightMeters,
                            bmi = bmi
                        )

                        onCalculated(result)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(50)
            ) {
                Text(text = "Calcular")
            }
        }
    }
}
