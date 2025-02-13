package com.example.cryptoapp.di

import android.app.Application
import com.example.cryptoapp.application.CryptoApplication
import com.example.cryptoapp.presentation.CoinDetailFragment
import com.example.cryptoapp.presentation.CoinPriceListActivity
import dagger.BindsInstance
import dagger.Component

@CryptoAppScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface CryptoAppComponent {

    fun inject(activity: CoinPriceListActivity)

    fun inject(fragment: CoinDetailFragment)

    fun inject(application: CryptoApplication)


    @Component.Factory
    interface AppComponentFactory {

        fun create(@BindsInstance application: Application): CryptoAppComponent
    }
}