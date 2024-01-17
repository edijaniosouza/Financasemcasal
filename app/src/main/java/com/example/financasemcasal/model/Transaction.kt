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
    @ColumnInfo("is_paid")
    val isPaid: Boolean = false,
    val category: String = "",
    @ColumnInfo("is_shared")
    val isShared: Boolean = false,
    @ColumnInfo("is_expense")
    val isExpense: Boolean,
    @ColumnInfo("created_at")
    val createdAt: Date = Date(),
    @ColumnInfo("updated_at")
    val updatedAt: Date = Date(),
)