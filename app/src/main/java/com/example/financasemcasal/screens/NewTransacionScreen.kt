package com.example.financasemcasal.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTransacionScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text(
                        "Nova Transação",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            "Navigation Icon Back to home screen"
                        )
                    }
                })
        }
    ) { paddingValues ->
        var transactionColor by remember { mutableStateOf(Color.Red) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
        )
        {

            var state by remember { mutableStateOf(0) }
            val titles = listOf("Saida", "Entrada")

            TabRow(
                selectedTabIndex = state,
                containerColor = transactionColor,
                contentColor = Color.White
            ) {
                titles.forEachIndexed { index, title ->
                    Tab(
                        selected = state == index,
                        onClick = { state = index },
                        text = {
                            Text(
                                text = title,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    )
                }
            }

            when (state) {
                0 -> {
                    transactionColor = Color.Red
                }

                1 -> {
                    transactionColor = Color.Green
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var title by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = title,
                    onValueChange = { newTitle ->
                        title = newTitle
                    }, label = { Text("Descrição") }, singleLine = true
                )

                var valor by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = valor,
                    onValueChange = { newValor ->
                        valor = newValor
                    }, label = { Text("Valor") }, singleLine = true
                )

                var category by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = category,
                    onValueChange = { newCategory ->
                        category = newCategory
                    }, label = { Text("Categoria") }, singleLine = true
                )

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Dividir", fontSize = 20.sp)
                    var isShared by remember { mutableStateOf(false) }
                    Checkbox(checked = isShared, onCheckedChange = { isShared = !isShared })
                }
            }


            ElevatedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = transactionColor,
                    contentColor = colorScheme.onPrimary
                ),
                onClick = {
                    navController.popBackStack()
                },
            ) {
                Text("Adicionar")
            }
        }
    }
}

@Preview
@Composable
fun NewTranctionScreenPreview() {
    NewTransacionScreen(rememberNavController())
}