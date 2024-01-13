package com.example.financasemcasal.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("transaction_id")
    val transactionID: Long = 0,
    val title: String,
    val value: BigDecimal,
    val icon: Int? = null,
    @ColumnInfo("is_expense")
    val isExpense: Boolean,
    val category: String = "",
    @ColumnInfo("is_shared")
    val isShared: Boolean = false
)