package com.example.financasemcasal.model

import java.math.BigDecimal

data class Transaction(
    val title: String,
    val value: BigDecimal,
    val icon: Int? = null,
    val isExpense: Boolean
)