package com.dbappgame.marvel.core.di.daggerhilt

import androidx.fragment.app.Fragment
import com.dbappgame.marvel.presentation.view.charecter.CharacterFragment
import com.dbappgame.marvel.presentation.view.charecter.CharactersView
import com.dbappgame.marvel.presentation.view.comics.ComicsFragment
import com.dbappgame.marvel.presentation.view.comics.ComicsView
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module
abstract class FragmentModule {
    @Binds
    abstract fun bindCharactersView(fragment: CharacterFragment): CharactersView



    companion object{
        @Provides
        fun bindCharacterFragment(fragment: Fragment): CharacterFragment {
            return fragment as CharacterFragment
        }
    }

}