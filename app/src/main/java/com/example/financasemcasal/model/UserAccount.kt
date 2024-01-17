package com.example.financasemcasal.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class UserAccount (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("user_account_id")
    val userAccountId: Long = 0,
    @ColumnInfo("user_name")
    val userName: String,
    @ColumnInfo("user_email")
    val userEmail: String,
    @ColumnInfo("user_password")
    val userPassword: String,
    @ColumnInfo("account_balance")
    val accountBalance: Long = 0L,
    val revenueTotal: Long = 0L,
    val expenseTotal: Long = 0L,
    @ColumnInfo("created_at")
    val createdAt: Date = Date(),
    @ColumnInfo("updated_at")
    val updatedAt: Date = Date(),
)