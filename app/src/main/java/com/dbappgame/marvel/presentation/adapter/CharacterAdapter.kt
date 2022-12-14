package com.dbappgame.marvel.presentation.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dbappgame.marvel.R
import com.dbappgame.marvel.core.utils.loadImage
import com.dbappgame.marvel.databinding.ItemCharacterBinding
import com.dbappgame.marvel.domain.model.MarvelCharacter


class CharacterAdapter (val onClickSeries: (MarvelCharacter) -> Unit,val onClickComic: (MarvelCharacter) -> Unit,val onClickDetail: (MarvelCharacter) -> Unit):
    ListAdapter<MarvelCharacter, CharacterAdapter.ViewHolder>(CharacterDiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemCharacterBinding =
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(marvelCharacter = getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemCharacterBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(marvelCharacter: MarvelCharacter) {
            with(binding) {
                val defaultImage =
                    ContextCompat.getDrawable(context, R.drawable.ic_launcher_background)
                image.loadImage(context, marvelCharacter.urlImage, defaultImage)
                name.text = marvelCharacter.name
                description.text = marvelCharacter.description

                binding.tvSeries.setOnClickListener { onClickComic(marvelCharacter) }
                binding.tvComics.setOnClickListener { onClickComic(marvelCharacter) }
                binding.tvDetail.setOnClickListener { onClickComic(marvelCharacter) }

            }
        }
    }


}


