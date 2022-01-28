package com.example.cryptocoins.data.modals

data class CoinsResponseItem(
    val askPrice: String,
    val at: Long,
    val baseAsset: String,
    val bidPrice: String,
    val highPrice: String,
    val lastPrice: String,
    val lowPrice: String,
    val openPrice: String,
    val quoteAsset: String,
    val symbol: String,
    val volume: String
)