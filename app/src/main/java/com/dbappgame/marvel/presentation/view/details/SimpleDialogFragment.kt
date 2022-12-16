package com.dbappgame.marvel.presentation.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.commit
import com.dbappgame.marvel.R
import com.dbappgame.marvel.databinding.FragmentSimpleDialogBinding
import com.dbappgame.marvel.domain.model.MarvelCharacter

class SimpleDialogFragment: DialogFragment() {

    companion object{
        val TAG: String = SimpleDialogFragment::class.java.canonicalName ?: ""
        fun newInstance() = SimpleDialogFragment()
    }

    private var _binding: FragmentSimpleDialogBinding? = null
    private val binding get() = _binding
    //private var character: MarvelCharacter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSimpleDialogBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //character = requireArguments().getParcelable("DETAILS")
        initView()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }


    private fun initView(){
        binding?.apply {
            buttonGoDetails.setOnClickListener {
                dismiss()
            }
            buttonGoBrowser.setOnClickListener {
                dismiss()
            }
        }
    }
}


