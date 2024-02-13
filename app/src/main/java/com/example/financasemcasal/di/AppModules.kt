package com.example.financasemcasal.di

import androidx.room.Room
import com.example.financasemcasal.database.AppDatabase
import com.example.financasemcasal.database.DATABASE_NAME
import com.example.financasemcasal.database.repository.TransactionRepository
import com.example.financasemcasal.database.repository.UserAccountRepository
import com.example.financasemcasal.viewmodel.TransactionViewModel
import com.example.financasemcasal.viewmodel.UserAccountViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

// SINGLE -> Cria uma unica instancia
// Factory -> Cria uma nova instancia toda vez que é chamado
// Viewmodel -> Especifico para viewModel para controlar o ciclo de vida

val appModules = module {
    single <AppDatabase>{
        Room.databaseBuilder(
            androidContext().applicationContext,
            AppDatabase::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    single {
        get<AppDatabase>().transactionDao()
    }

    single{
        get<AppDatabase>().TransactionWithUserAccountsDao()
    }

    single {
        TransactionRepository(get(), get(), get())
    }

    viewModel {
        TransactionViewModel(get())
    }
}

val userModules = module{
    single {
        get<AppDatabase>().userAccountDao()
    }
    single{
        UserAccountRepository(get())
    }

    viewModel{
        UserAccountViewModel(get())
    }
}