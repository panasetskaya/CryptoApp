package com.example.cryptoapp.di

import android.app.Application
import com.example.cryptoapp.data.database.AppDatabase
import com.example.cryptoapp.data.database.CoinInfoDao
import com.example.cryptoapp.data.network.ApiFactory
import com.example.cryptoapp.data.network.ApiService
import com.example.cryptoapp.data.repo.CoinRepositoryImpl
import com.example.cryptoapp.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @CryptoAppScope
    @Binds
    fun bindRepo(impl: CoinRepositoryImpl): CoinRepository

    companion object {

        @CryptoAppScope
        @Provides
        fun provideCoinInfoDao(application:Application): CoinInfoDao {
            return AppDatabase.getInstance(application).coinInfoDao()
        }

        @CryptoAppScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}