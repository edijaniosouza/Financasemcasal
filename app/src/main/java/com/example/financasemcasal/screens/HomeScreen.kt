package com.example.financasemcasal.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.financasemcasal.formatForBrazilianCurrency
import com.example.financasemcasal.helpers.NEW_TRANSACTION_SCREEN
import com.example.financasemcasal.helpers.userTest
import com.example.financasemcasal.screens.components.AccountBalanceCard
import com.example.financasemcasal.screens.components.TransacionCard
import com.example.financasemcasal.viewmodel.TransactionViewModel
import io.github.jan.supabase.SupabaseClient
import org.koin.androidx.compose.koinViewModel
import java.math.BigDecimal

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    supabase: SupabaseClient,
) {
    val context = currentCompositionLocalContext

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = colorScheme.primaryContainer,
                    titleContentColor = colorScheme.primary
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
            val edgePadding = 8.dp
            // Saldo

            // user teste
            val user = userTest
            AccountBalanceCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .fillMaxWidth()
                    .padding(edgePadding),
                balance = BigDecimal(user.accountBalance).formatForBrazilianCurrency()
            )

            // Transações
            Text(
                "Últimas Transações",
                modifier = Modifier.padding(edgePadding),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Divider(color = Color.Black, modifier = Modifier.padding(edgePadding))

            val viewModel = koinViewModel<TransactionViewModel>()
            val transactions by viewModel.allTransactions.observeAsState()

            // Teste
            val usuario by viewModel.getUser("teste@teste.com", "1234").observeAsState()
            Log.i("daoTeste", "HomeScreen: $usuario")

            val abc by viewModel.allTransactionsUsers.observeAsState()
            Log.i("daoTeste", "HomeScreen 2: $abc")

            if (transactions.isNullOrEmpty()) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Adicione uma nova Despesa / Receita")
//                    CircularProgressIndicator()
                }
            }

            LazyColumn {
                transactions?.let { transactionList ->
                    items(transactionList) { transacion ->
                        var showAlert by remember { mutableStateOf(false) }

                        if (showAlert) {
                            AlertDialog(
                                title = { Text("Excluir Transação") },
                                text = { Text("Você deseja excluir essa transação ${transacion.description}?") },
                                onDismissRequest = { showAlert = false },
                                dismissButton = {
                                    Button(onClick = {
                                        usuario?.let { it1 ->
                                            viewModel.createLink(
                                                transacion.id,
                                                it1.userAccountId
                                            )
                                        }
                                        showAlert = false
                                    }) {
                                        Text("Cancelar")
                                    }
                                },
                                confirmButton = {
                                    Button(onClick = { viewModel.deleteTransaction(transacion) }) {
                                        Text("Confirmar")
                                    }
                                }
                            )
                        }

                        TransacionCard(
                            transacion,
                            modifier = Modifier
                                .padding(horizontal = edgePadding, vertical = 3.dp)
                                .fillMaxWidth()
                                .height(100.dp)
                                .combinedClickable(
                                    onClick = {},
                                    onLongClick = {
                                        showAlert = true
                                    }
                                )
                        )
                    }
                }
            }
        }
    }
}
//
//@Preview(showSystemUi = true)
//@Composable
//fun HomeScreenPreview() {
//    HomeScreen(rememberNavController())
//}