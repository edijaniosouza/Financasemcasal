package com.example.financasemcasal.helpers

import com.example.financasemcasal.model.Transaction
import com.example.financasemcasal.model.UserAccount
import java.math.BigDecimal

val userTest = UserAccount(
    userName = "Edijanio",
    userEmail = "teste.teste@teste.com",
    userPassword = "123456",
    accountBalance = 1500L,
)

val testList = listOf<Transaction>(
    Transaction(
        description = "Besteira",
        value = BigDecimal("19"),
        isExpense = true
    ),
    Transaction(
        description = "Mercado",
        value = BigDecimal("56.99"),
        isExpense = true
    ),
    Transaction(
        description = "Boleto",
        value = BigDecimal("60.00"),
        isExpense = true
    ),
    Transaction(
        description = "Salario",
        value = BigDecimal("1800"),
        isExpense = false
    ),
    Transaction(
        description = "Besteira",
        value = BigDecimal("19"),
        isExpense = true
    ),
    Transaction(
        description = "Mercado",
        value = BigDecimal("56.99"),
        isExpense = true
    ),
    Transaction(
        description = "Boleto",
        value = BigDecimal("60.00"),
        isExpense = true
    ),
    Transaction(
        description = "Salario",
        value = BigDecimal("1800"),
        isExpense = false
    ),
    Transaction(
        description = "Besteira",
        value = BigDecimal("19"),
        isExpense = true
    ),
    Transaction(
        description = "Mercado",
        value = BigDecimal("56.99"),
        isExpense = true
    ),
    Transaction(
        description = "Boleto",
        value = BigDecimal("60.00"),
        isExpense = true
    ),
    Transaction(
        description = "Salario",
        value = BigDecimal("1800"),
        isExpense = false
    ),
    Transaction(
        description = "Besteira",
        value = BigDecimal("19"),
        isExpense = true
    ),
    Transaction(
        description = "Mercado",
        value = BigDecimal("56.99"),
        isExpense = true
    ),
    Transaction(
        description = "Boleto",
        value = BigDecimal("60.00"),
        isExpense = true
    ),
    Transaction(
        description = "Salario",
        value = BigDecimal("1800"),
        isExpense = false
    ),
)