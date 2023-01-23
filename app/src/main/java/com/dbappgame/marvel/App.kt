package com.dbappgame.marvel

import android.app.Application
import com.dbappgame.marvel.core.di.koin.fragmentModule
import com.dbappgame.marvel.core.di.koin.networkModule
import com.dbappgame.marvel.core.di.koin.presenterModule
import com.dbappgame.marvel.core.di.koin.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import java.util.logging.Level


class App: Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@App)
            modules(repositoryModule, presenterModule, networkModule, fragmentModule)
        }
    }

}