package com.example.cryptocoins.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocoins.data.Repository
import com.example.cryptocoins.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
):ViewModel() {
    private var job:Job? = null

    private val _postCoins: MutableStateFlow<Resource> =
        MutableStateFlow(Resource.Empty)
    val postCoins: MutableStateFlow<Resource> = _postCoins

    fun getCoins(){
        job = viewModelScope.launch {
            _postCoins.value = Resource.Loading
            repository.getCoins()
                .catch {
                    _postCoins.value = Resource.Error(it)
                }
                .collect {
                    _postCoins.value = Resource.Success(it)
                    Log.d("aditya", "getCoins:${_postCoins.value} ")
                }
        }
    }
}