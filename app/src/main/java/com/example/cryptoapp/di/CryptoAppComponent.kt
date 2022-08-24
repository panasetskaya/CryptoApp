package com.example.cryptoapp.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component

@CryptoAppScope
@Component(modules = [DomainModule::class])
interface CryptoAppComponent {

    @Component.Factory
    interface AppComponentFactory {

        fun create(@BindsInstance context: Context,
                   @BindsInstance application: Application): CryptoAppComponent
    }
}