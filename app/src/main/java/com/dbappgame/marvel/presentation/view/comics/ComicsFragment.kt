package com.dbappgame.marvel.presentation.view.comics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dbappgame.marvel.core.utils.showLongToast
import com.dbappgame.marvel.databinding.FragmentComicBinding
import com.dbappgame.marvel.domain.model.Comic
import com.dbappgame.marvel.presentation.presenter.comics.ComicsPresenter

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ComicsFragment: Fragment(), ComicsView {

    @Inject
    lateinit var presenter: ComicsPresenter

    companion object{
        val TAG: String = ComicsFragment::class.java.canonicalName ?: ""
        fun newInstance() = ComicsFragment()
    }

    private var _binding: FragmentComicBinding? = null
    private val binding get() = _binding

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
        presenter.getData(1011334)
    }

    override fun setData(list: List<Comic>) {
        requireContext().showLongToast(list.toString())
    }

    override fun showError(message: String) {
        requireContext().showLongToast(message)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
        _binding = null

    }

}