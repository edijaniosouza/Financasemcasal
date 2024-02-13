package com.example.financasemcasal

import android.app.Application
import com.example.financasemcasal.api.converters.DateSerializer
import com.example.financasemcasal.di.appModules
import com.example.financasemcasal.di.userModules
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import java.util.Date

class FinancasEmCasalApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@FinancasEmCasalApplication)
            modules(appModules, userModules)
        }

        initializeJson()
    }

    private fun initializeJson() {
        json = Json {
            serializersModule = SerializersModule {
                contextual(Date::class, DateSerializer)
            }
        }
    }

    companion object {
        lateinit var json: Json
            private set
    }
}