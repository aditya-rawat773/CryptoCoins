package com.example.cryptocoins.data.network

import com.example.cryptocoins.data.modals.CoinsResponse
import javax.inject.Inject

class RetrofitInstance @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCoins():CoinsResponse{
        return apiService.getCoins()
    }
}