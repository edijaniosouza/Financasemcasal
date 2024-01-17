package com.example.financasemcasal.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.Date

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("transaction_id")
    val transactionID: Long = 0,
    val description: String,
    val value: BigDecimal,
    val icon: Int? = null,
    @ColumnInfo("is_expense")
    val isExpense: Boolean,
    val category: String = "",
    @ColumnInfo("is_shared")
    val isShared: Boolean = false,
    @ColumnInfo("created_at")
    val createdAt: Date = Date(),
    @ColumnInfo("updated_at")
    val updatedAt: Date = Date(),
)