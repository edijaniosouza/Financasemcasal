package com.example.financasemcasal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.financasemcasal.helpers.HOME_SCREEN
import com.example.financasemcasal.helpers.NEW_TRANSACTION_SCREEN
import com.example.financasemcasal.screens.HomeScreen
import com.example.financasemcasal.screens.NewTransacionScreen
import com.example.financasemcasal.ui.theme.FinancasEmCasalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinancasEmCasalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = HOME_SCREEN){
                        composable(HOME_SCREEN){
                            HomeScreen(navController)
                        }
                        composable(NEW_TRANSACTION_SCREEN){
                            NewTransacionScreen(navController)
                        }
                    }
                }
            }
        }
    }
}
