package com.example.imccomposedbroom.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imccomposedbroom.ui.theme.ImcButton
import com.example.imccomposedbroom.ui.theme.ImcFieldBackground
import com.example.imccomposedbroom.ui.theme.ImcHint
import com.example.imccomposedbroom.ui.theme.ImcText

@Composable
fun ImcTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions = KeyboardActions.Default
){
    BasicTextField(
        value = value,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(
                color = ImcFieldBackground,
                shape = RoundedCornerShape(14.dp)
            ),
        singleLine = true,
        textStyle = TextStyle(
            color = ImcText,
            fontSize = 15.sp
        ),
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        cursorBrush = SolidColor(ImcButton),
        onValueChange = onValueChange,
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = placeholder,
                        fontSize = 14.sp,
                        color = ImcHint
                    )
                    innerTextField()
                }
            }
        }
    )
}