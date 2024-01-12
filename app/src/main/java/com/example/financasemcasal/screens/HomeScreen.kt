package com.example.financasemcasal.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.financasemcasal.helpers.testList
import com.example.financasemcasal.screens.components.TransacionCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(text = "Home Screen", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Icon(imageVector = Icons.Filled.Notifications, "Notification Icon")
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Add, "Float Action Button")
            }
        }
    ) {
        Column(Modifier.padding(it)) {
            val listaDeTeste = testList
            val edgePadding = 8.dp
            Text(
                "Últimas Transações",
                modifier = Modifier.padding(edgePadding),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Divider(color = Color.Black, modifier = Modifier.padding(edgePadding))
            LazyColumn {
                items(listaDeTeste) { transacion ->
                    TransacionCard(
                        transacion,
                        modifier = Modifier
                            .padding(horizontal = edgePadding, vertical = 3.dp)
                            .fillMaxWidth()
                            .height(100.dp),
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreview() {
//    HomeScreen()
}