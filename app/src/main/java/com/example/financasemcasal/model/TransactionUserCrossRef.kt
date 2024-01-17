package com.example.financasemcasal.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["transaction_id", "user_account_id"])
data class TransactionUserCrossRef(
    @ColumnInfo("transaction_id")
    val transactionId: Long,
    @ColumnInfo("user_account_id")
    val userAccountId: Long
)
