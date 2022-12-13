package com.dbappgame.marvel.core.di

import androidx.fragment.app.Fragment
import com.dbappgame.marvel.presentation.CharacterFragment
import com.dbappgame.marvel.presentation.view.CharactersView
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module
abstract class FragmentModule {

    @Binds
    abstract fun bindFragment(fragment: CharacterFragment): CharactersView

    companion object{
        @Provides
        fun bindActivity(fragment: Fragment): CharacterFragment {
            return fragment as CharacterFragment
        }
    }

}