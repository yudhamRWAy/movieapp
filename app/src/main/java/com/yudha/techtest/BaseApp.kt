package com.yudha.techtest

import android.app.Application
import com.yudha.techtest.di.*

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startInject()
    }

    private fun startInject() {
        val appModules = moduleNetwork + databaseModule + genreModule + moduleMovie + moduleSplashScreen
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@BaseApp)
            modules(appModules)
        }
    }
}