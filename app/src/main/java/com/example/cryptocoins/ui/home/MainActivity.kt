package com.example.cryptocoins.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptocoins.R
import com.example.cryptocoins.adapter.HomeAdapter
import com.example.cryptocoins.databinding.ActivityMainBinding
import com.example.cryptocoins.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel:HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeAdapter = HomeAdapter()
        binding.apply {
            homeRecyclerView.apply {
                adapter = homeAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }

        viewModel.getCoins()

        lifecycleScope.launchWhenStarted {
            viewModel.postCoins.collect {
                when (it) {
                    is Resource.Success -> {
                        binding.homeRecyclerView.itemAnimator = null
                        homeAdapter.submitList(null)
                        homeAdapter.submitList(it.data)
                    }
                }
            }
        }
    }
}