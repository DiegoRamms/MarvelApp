package com.dbappgame.marvel.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dbappgame.marvel.databinding.ItemComicBinding
import com.dbappgame.marvel.domain.model.Comic


class ComicsAdapter : ListAdapter<Comic, ComicsAdapter.ViewHolder>(ComicDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemComicBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.onBind(comic = getItem(position))
    }

    inner class ViewHolder(private val binding: ItemComicBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(comic: Comic){
            binding.name.text = comic.name
        }

    }


}