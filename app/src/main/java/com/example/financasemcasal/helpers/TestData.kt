package com.example.financasemcasal.helpers

import com.example.financasemcasal.model.Transaction
import com.example.financasemcasal.model.UserAccount

val userTest = UserAccount(
    userName = "Edijanio",
    userEmail = "teste.teste@teste.com",
    userPassword = "123456",
    accountBalance = 1500L,
)

val testList = listOf<Transaction>(
    Transaction(
        description = "Besteira",
        value = 19f,
        is_expense = 1
    ),
    Transaction(
        description = "Mercado",
        value = 56.99f,
        is_expense = 1
    ),
)