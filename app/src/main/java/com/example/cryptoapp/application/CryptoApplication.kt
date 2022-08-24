package com.example.cryptoapp.application

import android.app.Application
import com.example.cryptoapp.di.DaggerCryptoAppComponent

class CryptoApplication: Application() {

    val component by lazy {
        DaggerCryptoAppComponent.factory().create(this)
    }

}