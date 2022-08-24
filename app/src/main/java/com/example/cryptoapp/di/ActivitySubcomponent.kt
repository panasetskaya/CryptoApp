package com.example.cryptoapp.di

import com.example.cryptoapp.presentation.CoinPriceListActivity
import dagger.Subcomponent

@Subcomponent(
    modules = [ViewModelModule::class]
)
interface ActivitySubcomponent {

    fun inject(activity: CoinPriceListActivity)

    @Subcomponent.Factory
    interface Factory {

        fun create(
        ): ActivitySubcomponent
    }
}
