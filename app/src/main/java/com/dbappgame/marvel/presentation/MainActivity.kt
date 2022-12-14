package com.dbappgame.marvel.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.dbappgame.marvel.R
import com.dbappgame.marvel.core.utils.ifNull
import com.dbappgame.marvel.databinding.ActivityMainBinding
import com.dbappgame.marvel.presentation.view.charecter.CharacterFragment
import com.dbappgame.marvel.presentation.view.comics.ComicsFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), CharacterFragment.CharactersListener {


    lateinit var binding: ActivityMainBinding
    var charactersFragment: CharacterFragment? = null
    var comicsFragment: ComicsFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        savedInstanceState.ifNull {
            charactersFragment = CharacterFragment.newInstance()
            supportFragmentManager.commit {
                charactersFragment?.let { fragment ->
                    replace(R.id.container, fragment, CharacterFragment.TAG)
                }
            }
        }
    }

    override fun onClickComics(characterId: Int) {
        comicsFragment = ComicsFragment.newInstance()
        supportFragmentManager.commit {
            comicsFragment?.let { fragment ->
                replace(R.id.container, fragment, ComicsFragment.TAG).addToBackStack(ComicsFragment.TAG)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        charactersFragment?.let { supportFragmentManager.putFragment(outState,
            CharacterFragment.TAG,it) }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        charactersFragment = supportFragmentManager.getFragment(savedInstanceState,
            CharacterFragment.TAG) as CharacterFragment
    }

}


