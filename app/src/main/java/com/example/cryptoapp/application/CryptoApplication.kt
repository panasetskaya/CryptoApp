package com.example.cryptoapp.application

import android.app.Application
import androidx.work.Configuration
import com.example.cryptoapp.data.database.AppDatabase
import com.example.cryptoapp.data.mapper.CoinMapper
import com.example.cryptoapp.data.network.ApiFactory
import com.example.cryptoapp.data.workers.RefreshDataWorkerFactory
import com.example.cryptoapp.di.DaggerCryptoAppComponent

class CryptoApplication: Application(), Configuration.Provider {

    val component by lazy {
        DaggerCryptoAppComponent.factory().create(this)
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder().setWorkerFactory(RefreshDataWorkerFactory(
            AppDatabase.getInstance(this).coinInfoDao(),
            ApiFactory.apiService,
            CoinMapper()
        )).build()
    }
}