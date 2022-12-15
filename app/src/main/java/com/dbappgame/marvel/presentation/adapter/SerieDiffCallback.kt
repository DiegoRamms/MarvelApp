package com.dbappgame.marvel.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.dbappgame.marvel.domain.model.Series

object SerieDiffCallback: DiffUtil.ItemCallback<Series>() {
    override fun areItemsTheSame(oldItem: Series, newItem: Series): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Series, newItem: Series): Boolean {
        return oldItem == newItem
    }
}