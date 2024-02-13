package com.example.financasemcasal.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Entity(tableName = "transactions")
@Serializable
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("transaction_id")
    val id: Long = 0,
    @ColumnInfo("created_at")
    val created_at: Instant? = null,
    @ColumnInfo("updated_at")
    val updated_at: Instant? = null,
    val description: String,
    val value: Float,
    @ColumnInfo("is_paid")
    val is_paid: Int = 0,
    @ColumnInfo("is_shared")
    val is_shared: Int = 0,
    @ColumnInfo("is_expense")
    val is_expense: Int = 1,
    val category_id: Int? = null,
    val shared_user_id: String? = null,
)