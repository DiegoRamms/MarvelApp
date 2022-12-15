package com.dbappgame.marvel.presentation.view.series

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dbappgame.marvel.core.utils.parcelableArrayList
import com.dbappgame.marvel.databinding.FragmentSerieBinding
import com.dbappgame.marvel.domain.model.Series
import com.dbappgame.marvel.presentation.adapter.SeriesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeriesFragment: Fragment() {

    companion object{
        val TAG: String = SeriesFragment::class.java.canonicalName ?: ""
        fun newInstance() = SeriesFragment()
    }

    private var _binding: FragmentSerieBinding? = null
    private val binding get() = _binding
    private var series: List<Series>? = null
    private val seriesAdapter by lazy { SeriesAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSerieBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        series = requireArguments().parcelableArrayList("SERIES")
        initView()
    }

    private fun initView(){
        binding?.rvSerie?.apply {
            adapter = seriesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        seriesAdapter.submitList(series)
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null

    }
}