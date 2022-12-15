package com.dbappgame.marvel.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dbappgame.marvel.databinding.ItemSerieBinding
import com.dbappgame.marvel.domain.model.Series

class SeriesAdapter:
    ListAdapter<Series, SeriesAdapter.ViewHolder>(SerieDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemSerieBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(serie = getItem(position))
    }

    inner class ViewHolder(private val binding: ItemSerieBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(serie: Series){
            binding.nameSerie.text = serie.name
        }

    }
}