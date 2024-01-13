package com.example.financasemcasal.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.financasemcasal.helpers.NEW_TRANSACTION_SCREEN
import com.example.financasemcasal.helpers.testList
import com.example.financasemcasal.screens.components.TransacionCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = { Text("Home Screen", fontWeight = FontWeight.Bold) },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            "Notification Icon"
                        )
                    }
                },
                scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(NEW_TRANSACTION_SCREEN)
            }, containerColor = colorScheme.primary) {
                Icon(Icons.Filled.Add, contentDescription = "Float Action Button")
            }
        },

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

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}