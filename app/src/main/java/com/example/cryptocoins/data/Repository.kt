package com.example.cryptocoins.data

import android.util.Log
import com.example.cryptocoins.data.modals.CoinsResponse
import com.example.cryptocoins.data.network.RetrofitInstance
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class Repository @Inject constructor(
    private val retrofitInstance: RetrofitInstance
) {
    fun getCoins(): Flow<CoinsResponse> {
        return flow {
                while (true) {
                    val data = retrofitInstance.getCoins()
                    emit(data)
                    delay(5000)
                }

        }
    }
}