package com.example.cryptoapp.di

import com.example.cryptoapp.data.repo.CoinRepositoryImpl
import com.example.cryptoapp.domain.CoinRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @CryptoAppScope
    @Binds
    fun bindRepo(impl: CoinRepositoryImpl): CoinRepository

}