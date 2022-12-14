package com.dbappgame.marvel.presentation.view.comics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dbappgame.marvel.core.utils.parcelableArrayList
import com.dbappgame.marvel.databinding.FragmentComicBinding
import com.dbappgame.marvel.domain.model.Comic
import com.dbappgame.marvel.presentation.adapter.ComicsAdapter

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicsFragment: Fragment() {

    companion object{
        val TAG: String = ComicsFragment::class.java.canonicalName ?: ""
        fun newInstance() = ComicsFragment()
    }

    private var _binding: FragmentComicBinding? = null
    private val binding get() = _binding
    private var comics: List<Comic>? = null
    private val comicsAdapter by lazy { ComicsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentComicBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        comics = requireArguments().parcelableArrayList("COMICS")
        initView()
    }

    private fun initView(){
        binding?.rvComic?.apply {
            adapter = comicsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        comicsAdapter.submitList(comics)
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null

    }

}