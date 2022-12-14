package com.dbappgame.marvel.presentation.view.charecter

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dbappgame.marvel.core.utils.ifNull
import com.dbappgame.marvel.core.utils.parcelableArrayList
import com.dbappgame.marvel.core.utils.showLongToast
import com.dbappgame.marvel.databinding.FragmentCharactersBinding
import com.dbappgame.marvel.domain.model.MarvelCharacter
import com.dbappgame.marvel.presentation.adapter.CharacterAdapter
import com.dbappgame.marvel.presentation.presenter.character.CharactersPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CharacterFragment : Fragment(), CharactersView {

    companion object {
        val TAG: String = CharacterFragment::class.java.canonicalName ?: ""
        fun newInstance() = CharacterFragment()
    }

    @Inject
    lateinit var presenter: CharactersPresenter
    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding
    private var characters: List<MarvelCharacter>? = null
    private var charactersListener: CharactersListener? = null
    private val characterAdapter by lazy {
        CharacterAdapter(
            ::onClickItemSeries,
            ::onClickItemComics,
            ::onClickItemDetail
        )
    }


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
        initView()

        characters.ifNull { presenter.getData() }

    }

    private fun initView() {
        binding?.rvCharacters?.apply {
            adapter = characterAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }


    override fun loadView(isLoading: Boolean) {
        Log.e("Loading", isLoading.toString())
    }

    override fun setData(list: List<MarvelCharacter>) {
        characters = list
        characters?.let { showInfo(it) }
    }

    override fun showError(error: String) {
        requireContext().showLongToast(error)
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        characters?.let {
            outState.putParcelableArrayList(
                "LIST",
                characters as ArrayList<out Parcelable>
            )
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        characters = savedInstanceState?.parcelableArrayList("LIST")
        characters?.let { showInfo(it) }
    }


    private fun showInfo(list: List<MarvelCharacter>) {
        characterAdapter.submitList(list)
    }

    private fun onClickItemSeries(marvelCharacter: MarvelCharacter) {
        requireContext().showLongToast("Series")
    }

    private fun onClickItemComics(marvelCharacter: MarvelCharacter) {
        requireContext().showLongToast(marvelCharacter.toString())
        charactersListener?.onClickComics(marvelCharacter)
    }

    private fun onClickItemDetail(marvelCharacter: MarvelCharacter) {
        requireContext().showLongToast("Detail")
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            charactersListener = context as CharactersListener
        } catch (e: ClassCastException) {
            print(e.toString())
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
        _binding = null
    }

    interface CharactersListener {
        fun onClickSeries(character: MarvelCharacter)
        fun onClickComics(character: MarvelCharacter)
        fun onClickDetail(character: MarvelCharacter)
    }

}




