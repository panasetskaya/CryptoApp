package com.example.cryptoapp.data.repo

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.cryptoapp.data.database.AppDatabase
import com.example.cryptoapp.data.mapper.CoinMapper
import com.example.cryptoapp.data.network.ApiFactory
import com.example.cryptoapp.data.workers.RefreshDataWorker
import com.example.cryptoapp.data.workers.RefreshDataWorker.Companion.WORKER_NAME
import com.example.cryptoapp.domain.CoinInfo
import com.example.cryptoapp.domain.CoinRepository
import kotlinx.coroutines.delay
import java.lang.Exception

class CoinRepositoryImpl(private val application: Application) : CoinRepository {

    private val dao = AppDatabase.getInstance(application).coinInfoDao()
    private val apiService = ApiFactory.apiService
    private val mapper = CoinMapper()

    override fun getCoinInfoList(): LiveData<List<CoinInfo>> {
        return Transformations.map(dao.getPriceList()) { dbModelList ->
            dbModelList.map { dbModel ->
                mapper.mapDbModelToDomainEntity(dbModel)
            }
        }
    }

    override fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo> {
        return Transformations.map(dao.getPriceInfoAboutCoin(fromSymbol)) { dbModel ->
            mapper.mapDbModelToDomainEntity(dbModel)
        }
    }

    override fun loadData() {

        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            WORKER_NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.makeRequest()
        )
    }

}