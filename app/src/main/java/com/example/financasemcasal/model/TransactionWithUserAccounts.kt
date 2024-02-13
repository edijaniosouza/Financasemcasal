package com.example.financasemcasal.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation

data class TransactionWithUserAccounts(
    @Embedded val transaction: Transaction,
    @Relation(
        parentColumn = "transaction_id",
        entityColumn = "user_account_id",
        associateBy = Junction(TransactionUserCrossRef::class)
    )
    val userAccounts: List<UserAccount>
)
