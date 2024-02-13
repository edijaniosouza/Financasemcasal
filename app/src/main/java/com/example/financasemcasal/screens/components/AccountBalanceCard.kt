package com.example.financasemcasal.screens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.financasemcasal.formatForBrazilianCurrency
import com.example.financasemcasal.helpers.userTest
import java.math.BigDecimal

@Composable
fun AccountBalanceCard(
    modifier: Modifier,
    balance: String,
) {
    Card(
        modifier = modifier,
        border = BorderStroke(1.dp, Color.Black)
    ) {

        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Saldo: ", fontSize = 24.sp)
                Text(balance, fontSize = 24.sp)
            }
            Divider(color = Color.Black, modifier = Modifier.padding(10.dp))

            val fontSize = 18.sp
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Receita: ", fontSize = fontSize)
                Text(balance, fontSize = fontSize)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Despesa: ", fontSize = fontSize)
                Text(balance, fontSize = fontSize)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AccountBalanceCardPreview() {
    AccountBalanceCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .fillMaxWidth()
            .padding(8.dp),
        balance = BigDecimal(userTest.accountBalance).formatForBrazilianCurrency()
    )
}