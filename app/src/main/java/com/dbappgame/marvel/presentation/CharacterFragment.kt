package com.dbappgame.marvel.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dbappgame.marvel.databinding.FragmentCharactersBinding
import com.dbappgame.marvel.domain.model.MarvelCharacter
import com.dbappgame.marvel.presentation.presenter.CharactersPresenter
import com.dbappgame.marvel.presentation.view.CharactersView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CharacterFragment: Fragment(), CharactersView {

    companion object{
        val TAG: String = CharacterFragment::class.java.canonicalName ?: ""
        fun newInstance() = CharacterFragment()
    }

    @Inject
    lateinit var presenter: CharactersPresenter
    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharactersBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getData()
    }


    override fun loadView(isLoading: Boolean) {
        Log.e("Loading",isLoading.toString())
    }

    override fun showList(list: List<MarvelCharacter>) {
        Log.e("list", list.toString())
        binding?.tvPrueba?.text = list.toString()
    }

    override fun showError(error: String) {
        Log.e("Error", error)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
        _binding = null

    }
}