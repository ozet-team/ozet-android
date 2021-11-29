package com.team.ozet.di

import android.app.Application
import androidx.databinding.library.BuildConfig
import com.team.ozet.module.apiModule
import com.team.ozet.module.localDataModule
import com.team.ozet.module.repositoryModule
import com.team.ozet.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class KoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            if (BuildConfig.DEBUG) {
                androidLogger()
            } else {
                androidLogger(Level.NONE)
            }
            androidContext(this@KoinApplication)
            modules(
                repositoryModule,
                localDataModule,
                viewModelModule,
                apiModule,
            )
        }


    }

    override fun onTerminate() {
        super.onTerminate()
        instance = null
    }

    companion object {
        private var instance: KoinApplication? = null

        fun getGlobalApplicationContext(): KoinApplication? {
            checkNotNull(instance) { "This Application does not inherit com.kakao.GlobalApplication" }
            return instance
        }
    }

}