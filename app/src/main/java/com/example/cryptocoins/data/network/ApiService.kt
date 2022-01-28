package com.example.cryptocoins.data.network

import com.example.cryptocoins.data.modals.CoinsResponse
import retrofit2.http.GET

interface ApiService {

    @GET("sapi/v1/tickers/24hr")
    suspend fun getCoins():CoinsResponse
}