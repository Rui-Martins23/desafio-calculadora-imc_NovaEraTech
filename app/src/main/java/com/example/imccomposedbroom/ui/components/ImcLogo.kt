package com.example.imccomposedbroom.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Scale
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ImcLogo(
    modifier: Modifier = Modifier,
    size: Dp = 104.dp,
    color: Color = Color.White
) {
    Box(
        modifier = modifier
            .size(size)
            .border(
                width = size * 0.055f,
                color = color,
                shape = RoundedCornerShape(size * 0.18f)
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .size(size * 0.55f),
            imageVector = Icons.Filled.Scale,
            contentDescription = "IMC LOGO",
            tint = color
        )
    }
}