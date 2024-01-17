package com.example.financasemcasal.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.financasemcasal.R
import com.example.financasemcasal.model.Transaction
import com.example.financasemcasal.formatForBrazilianCurrency
import java.math.BigDecimal

@Composable
fun TransacionCard(
    transacion: Transaction,
    modifier: Modifier
) {
    Card(
        modifier = modifier
    ) {

        Row(
            Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_food),
                modifier = Modifier.size(50.dp),
                contentDescription = "Category Icon",
            )
            Column {
                Text(text = transacion.description, fontSize = 22.sp)
                Text(text = transacion.value.formatForBrazilianCurrency(), fontSize = 18.sp)
            }

            val isExpense =
                if (transacion.isExpense) R.drawable.icon_arrow_down else R.drawable.icon_arrow_up
            val isExpenseColor = if (transacion.isExpense) Color.Red else Color.Black

            Icon(
                painter = painterResource(id = isExpense),
                tint = isExpenseColor,
                contentDescription = "Icon up or down"
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun TransacionCardPreview() {
    TransacionCard(
        transacion = Transaction(description = "TESTE", value = BigDecimal("19.3"), isExpense = true),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(100.dp),
    )
}