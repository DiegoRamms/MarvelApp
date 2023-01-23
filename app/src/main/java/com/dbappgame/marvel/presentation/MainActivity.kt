package com.dbappgame.marvel.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.commit
import com.dbappgame.marvel.R
import com.dbappgame.marvel.core.utils.ifNull
import com.dbappgame.marvel.databinding.ActivityMainBinding
import com.dbappgame.marvel.databinding.FragmentDetailsBinding
import com.dbappgame.marvel.domain.model.MarvelCharacter
import com.dbappgame.marvel.domain.model.Series
import com.dbappgame.marvel.presentation.view.charecter.CharacterFragment
import com.dbappgame.marvel.presentation.view.comics.ComicsFragment
import com.dbappgame.marvel.presentation.view.details.DetailsFragment
import com.dbappgame.marvel.presentation.view.details.SimpleDialogFragment
import com.dbappgame.marvel.presentation.view.series.SeriesFragment
import dagger.hilt.android.AndroidEntryPoint
import org.koin.android.ext.android.inject
import java.util.ArrayList



class MainActivity : AppCompatActivity(), CharacterFragment.CharactersListener {

    lateinit var binding: ActivityMainBinding
    val charactersFragment: CharacterFragment by inject()
    var comicsFragment: ComicsFragment? = null
    var seriesFragment: SeriesFragment? = null
    var detailsFragment: DetailsFragment? = null
    var simpleDialogFragment: SimpleDialogFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        savedInstanceState.ifNull {
            supportFragmentManager.commit {
                charactersFragment?.let { fragment ->
                    replace(R.id.container, fragment, CharacterFragment.TAG)
                }
            }
        }
    }

    override fun onClickSeries(character: MarvelCharacter) {
        seriesFragment = SeriesFragment.newInstance()
        seriesFragment?.arguments = Bundle().apply {
            putParcelableArrayList("SERIES", character.series as ArrayList<out Parcelable>)
        }

        supportFragmentManager.commit {
            seriesFragment?.let { fragment ->
                replace(R.id.container, fragment, SeriesFragment.TAG).addToBackStack(SeriesFragment.TAG)
            }
        }
    }

    override fun onClickComics(character: MarvelCharacter) {
        comicsFragment = ComicsFragment.newInstance()
        comicsFragment?.arguments = Bundle().apply {
            putParcelableArrayList("COMICS",character.comics as ArrayList<out Parcelable>)
        }
        supportFragmentManager.commit {
            comicsFragment?.let { fragment ->
                replace(R.id.container, fragment, ComicsFragment.TAG).addToBackStack(ComicsFragment.TAG)
            }
        }
    }

    override fun onClickDetail(character: MarvelCharacter) {
        //simpleDialogFragment = SimpleDialogFragment.newInstance()
        //simpleDialogFragment?.show(supportFragmentManager, SimpleDialogFragment.TAG)

        detailsFragment = DetailsFragment.newInstance()
        detailsFragment?.arguments = Bundle().apply {
            putParcelable("DETAILS",character)
        }
        supportFragmentManager.commit {
            detailsFragment?.let { fragment ->
                replace(R.id.container, fragment, DetailsFragment.TAG).addToBackStack(DetailsFragment.TAG)
            }
        }

    }

    override fun onClickDialog(character: MarvelCharacter) {
      //PENDING
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        charactersFragment?.let { supportFragmentManager.putFragment(outState,
            CharacterFragment.TAG,it) }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

    }

}


