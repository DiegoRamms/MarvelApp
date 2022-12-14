package com.dbappgame.marvel.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.dbappgame.marvel.domain.model.MarvelCharacter


object CharacterDiffCallback: DiffUtil.ItemCallback<MarvelCharacter>(){
    override fun areItemsTheSame(oldItem: MarvelCharacter, newItem: MarvelCharacter): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MarvelCharacter, newItem: MarvelCharacter): Boolean {
        return oldItem == newItem
    }

}