package com.dbappgame.marvel.core.di

import com.dbappgame.marvel.presentation.presenter.character.CharactersPresenter
import com.dbappgame.marvel.presentation.presenter.character.CharactersPresenterImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent


@Module
@InstallIn(FragmentComponent::class)
abstract class PresenterModule {

    @Binds
    abstract fun bindCharacterPresenter(imp: CharactersPresenterImp): CharactersPresenter


}


