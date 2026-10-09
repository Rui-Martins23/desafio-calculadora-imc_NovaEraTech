package com.example.imccomposedbroom.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imccomposedbroom.R
import com.example.imccomposedbroom.data.local.BmiRecord
import com.example.imccomposedbroom.domain.BmiCalculator
import com.example.imccomposedbroom.ui.theme.ImcClassification
import com.example.imccomposedbroom.ui.theme.ImcFieldBackground
import com.example.imccomposedbroom.ui.theme.ImcLabel
import com.example.imccomposedbroom.ui.theme.ImcText
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HistoryRow(
    record: BmiRecord,
    onDelete: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 12.dp)
                ) {
                    Text(
                        text = BmiCalculator.format(record.bmi),
                        color = ImcText,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = record.classification,
                        color = ImcClassification,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = ("Peso ${record.weightKg} " + "Altura ${record.heightMeters}"),
                        color = ImcLabel,
                        fontSize = 13.sp
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = formatCalculatedAt(record.calculatedAt),
                        color = ImcLabel,
                        fontSize = 12.sp
                    )
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = "Delete",
                        tint = ImcLabel,
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .size(24.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = onDelete
                            )
                    )
                }
            }
        }
        HorizontalDivider(color = ImcFieldBackground, thickness = 1.dp)
    }
}

private fun formatCalculatedAt(epochMillis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.forLanguageTag("pt-BR"))
    return formatter.format(Date(epochMillis))
}

private fun formatMeasure(value: Double, decimals: Int): String {
    return String.format(Locale.US, "%.${decimals}f", value)
}