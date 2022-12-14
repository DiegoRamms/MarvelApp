package com.dbappgame.marvel.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.dbappgame.marvel.domain.model.Comic


object ComicDiffCallback: DiffUtil.ItemCallback<Comic>(){
    override fun areItemsTheSame(oldItem: Comic, newItem: Comic): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Comic, newItem: Comic): Boolean {
        return oldItem == newItem
    }
}