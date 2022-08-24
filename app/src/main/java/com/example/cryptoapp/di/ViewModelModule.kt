package com.example.cryptoapp.di

import androidx.lifecycle.AndroidViewModel
import com.example.cryptoapp.presentation.CoinViewModel
import dagger.Binds
import dagger.Module

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModel(impl: CoinViewModel): AndroidViewModel
}