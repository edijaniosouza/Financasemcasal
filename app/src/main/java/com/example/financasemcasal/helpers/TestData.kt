package com.example.financasemcasal.helpers

import com.example.financasemcasal.model.Transaction
import java.math.BigDecimal

val testList = listOf<Transaction>(
    Transaction(
        title = "Besteira",
        value = BigDecimal("19"),
        isExpense = true
    ),
    Transaction(
        title = "Mercado",
        value = BigDecimal("56.99"),
        isExpense = true
    ),
    Transaction(
        title = "Boleto",
        value = BigDecimal("60.00"),
        isExpense = true
    ),
    Transaction(
        title = "Salario",
        value = BigDecimal("1800"),
        isExpense = false
    ),
)