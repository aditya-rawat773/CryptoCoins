package com.example.cryptocoins.utils

import com.example.cryptocoins.data.modals.CoinsResponse

sealed class Resource{
    object Loading : Resource()
    class Error(val msg: Throwable) : Resource()
    class Success(val data: CoinsResponse): Resource()
    object Empty : Resource()
}