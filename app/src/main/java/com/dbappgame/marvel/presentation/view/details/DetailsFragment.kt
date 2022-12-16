package com.dbappgame.marvel.presentation.view.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dbappgame.marvel.R
import com.dbappgame.marvel.core.utils.ifNull
import com.dbappgame.marvel.core.utils.loadImage
import com.dbappgame.marvel.core.utils.parcelableArrayList
import com.dbappgame.marvel.databinding.FragmentComicBinding
import com.dbappgame.marvel.databinding.FragmentDetailsBinding
import com.dbappgame.marvel.domain.model.Comic
import com.dbappgame.marvel.domain.model.MarvelCharacter
import com.dbappgame.marvel.presentation.adapter.ComicsAdapter
import com.dbappgame.marvel.presentation.presenter.character.CharactersPresenter
import com.dbappgame.marvel.presentation.presenter.details.DetailsPresenter
import com.dbappgame.marvel.presentation.view.comics.ComicsFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment: Fragment() {

    companion object{
        val TAG: String = DetailsFragment::class.java.canonicalName ?: ""
        fun newInstance() = DetailsFragment()
    }

    lateinit var presenter: DetailsPresenter
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding
    private var character: MarvelCharacter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        character = requireArguments().getParcelable("DETAILS")
        initView()
    }

    private fun initView(){
        binding?.apply {
            val defaultImage =
                context?.let { ContextCompat.getDrawable(it, R.drawable.ic_launcher_background) }

                nameCharacter.text = character?.name
                descriptionCharacter.text = character?.description
            context?.let { character?.let { it1 -> imageCharacter.loadImage(it, it1.urlImage, defaultImage) } }
            }
        }
    }

