package com.example.financasemcasal.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.financasemcasal.model.Transaction
import com.example.financasemcasal.uiState.NewTransactionScreenState
import com.example.financasemcasal.viewmodel.TransactionViewModel
import org.koin.androidx.compose.koinViewModel


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
            val newTransactionScreenState = remember {
                NewTransactionScreenState()
            }

            val description = newTransactionScreenState.description
            val value = newTransactionScreenState.value
            val category = newTransactionScreenState.category
            val isShared = newTransactionScreenState.isShared
            val tabState = newTransactionScreenState.tabState
            val tabNames = newTransactionScreenState.tabNames

            TabRow(
                selectedTabIndex = tabState,
                containerColor = transactionColor,
                contentColor = Color.White
            ) {
                tabNames.forEachIndexed { index, title ->
                    Tab(
                        selected = tabState == index,
                        onClick = { newTransactionScreenState.tabState = index },
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
            var isExpense = 0
            when (tabState) {
                0 -> {
                    transactionColor = Color.Red
                    isExpense = 1
                }

                1 -> {
                    transactionColor = Color.Green
                    isExpense = 0
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                OutlinedTextField(
                    value = description,
                    onValueChange = newTransactionScreenState.onDescriptionChange,
                    label = { Text("Descrição") }, singleLine = true
                )

                OutlinedTextField(
                    value = value,
                    onValueChange = newTransactionScreenState.onValueChange,
                    label = { Text("Valor") }, singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                )

                OutlinedTextField(
                    value = category,
                    onValueChange = newTransactionScreenState.onCategoryChange,
                    label = { Text("Categoria") }, singleLine = true
                )

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Dividir", fontSize = 20.sp)
                    Checkbox(
                        checked = isShared,
                        onCheckedChange = newTransactionScreenState.onCheckedChange
                    )
                }
            }

            val viewModel = koinViewModel<TransactionViewModel>()
            ElevatedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = transactionColor,
                    contentColor = colorScheme.onPrimary
                ),
                onClick = {
                    viewModel.insertTransaction(
                        Transaction(
                            description = description,
                            value = value as Float,
                            is_expense = isExpense,
                        )
                    )
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