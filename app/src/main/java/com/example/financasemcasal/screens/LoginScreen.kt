package com.example.financasemcasal.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.financasemcasal.R
import io.github.jan.supabase.SupabaseClient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    supabase: SupabaseClient,
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var email by remember { mutableStateOf("") }
        Text("E-mail", textAlign = TextAlign.Start)
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("e-mail") }
        )
        var password by remember { mutableStateOf("") }
        Text("Senha", textAlign = TextAlign.Start)
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Insira sua senha") }
        )
        val context = currentCompositionLocalContext
        ElevatedButton(onClick = { /*TODO*/
//            Toast.makeText(this, "abc", Toast.LENGTH_SHORT).show()
        }) {
            Text("Entrar")
        }

        Divider(thickness = 1.dp, modifier = Modifier.padding(16.dp))

        Column(
//            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Autenticação google"
                )
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun LoginScreenPreview() {
//    LoginScreen(navController = rememberNavController(), supabase = supabase)
//}