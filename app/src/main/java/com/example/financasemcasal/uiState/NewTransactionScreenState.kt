package com.example.financasemcasal.uiState

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class NewTransactionScreenState (){

    var description by mutableStateOf("")
        private set

    var value by mutableStateOf("")
        private set
    var category by mutableStateOf("")
        private set
    var isShared by mutableStateOf(false)
    var tabState by mutableIntStateOf(0)
    val tabNames = listOf("Saida", "Entrada")

    val onDescriptionChange: (String)->Unit = {newDescription ->
        description = newDescription
    }

    val onValueChange: (String)->Unit = {newValue ->
        value = newValue
    }
    val onCategoryChange: (String)->Unit = {newCategory ->
        category = newCategory
    }

    val onCheckedChange: (Boolean)->Unit = {newCheckedValue ->
        isShared = newCheckedValue
    }
}