package com.example.imccomposedbroom.ui.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imccomposedbroom.data.local.BmiRecord
import com.example.imccomposedbroom.ui.components.HistoryRow
import com.example.imccomposedbroom.ui.components.ImcHeader
import com.example.imccomposedbroom.ui.theme.ImcLabel
import com.example.imccomposedbroom.ui.theme.ImcScreenBackground

@Composable
fun HistoryScreen(
    modifier: Modifier = Modifier,
    records: List<BmiRecord>,
    onDelete: (Long) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ImcScreenBackground)
    ) {
        ImcHeader(
            description = "Histórico"
        )

        if (records.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .navigationBarsPadding(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Você não possui registros de histórico",
                    color = ImcLabel,
                    fontSize = 15.sp
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .navigationBarsPadding(),
                contentPadding = PaddingValues(top = 8.dp, bottom = 12.dp)
            ) {
                items(records, key = { it.id }) { record ->
                    HistoryRow(record, onDelete = { onDelete(record.id) })
                }
            }
        }
    }
}
