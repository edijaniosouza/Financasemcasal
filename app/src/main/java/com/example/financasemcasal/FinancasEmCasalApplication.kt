package com.example.financasemcasal

import android.app.Application
import com.example.financasemcasal.di.appModules
import com.example.financasemcasal.di.userModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FinancasEmCasalApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@FinancasEmCasalApplication)
            modules(appModules, userModules)
        }
    }
}