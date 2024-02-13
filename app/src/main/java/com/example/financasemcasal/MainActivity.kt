package com.example.financasemcasal

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.financasemcasal.helpers.HOME_SCREEN
import com.example.financasemcasal.helpers.LOGIN_SCREEN
import com.example.financasemcasal.helpers.NEW_TRANSACTION_SCREEN
import com.example.financasemcasal.model.Transaction
import com.example.financasemcasal.screens.HomeScreen
import com.example.financasemcasal.screens.LoginScreen
import com.example.financasemcasal.screens.NewTransacionScreen
import com.example.financasemcasal.ui.theme.FinancasEmCasalTheme
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val supabase = createSupabaseClient(
            supabaseUrl = "https://cqlwfmnxjupqycggxbfv.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNxbHdmbW54anVwcXljZ2d4YmZ2Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDc3NjAyNjcsImV4cCI6MjAyMzMzNjI2N30.nzQbAdyjmTbZkyb7eLAnPq44vin55Js-i29mwaoLFxI"
        ) {
            install(Postgrest)
        }

        var teste: List<Transaction>

        CoroutineScope(Dispatchers.IO).launch{
                teste = supabase.from("transactions").select().decodeList<Transaction>()
                Log.i("TESTEAPI", "LoginScreen: $teste")
        }
        setContent {
            FinancasEmCasalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = LOGIN_SCREEN) {
                        composable(HOME_SCREEN) {
                            HomeScreen(navController, supabase)
                        }
                        composable(NEW_TRANSACTION_SCREEN) {
                            NewTransacionScreen(navController)
                        }

                        composable(LOGIN_SCREEN) {
                            LoginScreen(navController, supabase)
                        }
                    }
                }
            }
        }
    }
}
