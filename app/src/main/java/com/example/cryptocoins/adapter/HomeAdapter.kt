package com.example.cryptocoins.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocoins.data.modals.CoinsResponseItem
import com.example.cryptocoins.databinding.ItemHomeBinding

class HomeAdapter(): ListAdapter<CoinsResponseItem, HomeAdapter.CoinsViewHolder>(CoinsComp()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinsViewHolder {
        val binding =
            ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return (CoinsViewHolder(binding))
    }

    override fun onBindViewHolder(holder: CoinsViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }


    class CoinsViewHolder(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(coins: CoinsResponseItem) {
            binding.apply {
                baseAsset.text = coins.baseAsset
                lastPrice.text = coins.lastPrice
            }
        }
    }

    class CoinsComp : DiffUtil.ItemCallback<CoinsResponseItem>() {
        override fun areItemsTheSame(oldItem: CoinsResponseItem, newItem: CoinsResponseItem) =
            oldItem.baseAsset == newItem.baseAsset

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: CoinsResponseItem, newItem: CoinsResponseItem) =
            oldItem == newItem
    }
}

