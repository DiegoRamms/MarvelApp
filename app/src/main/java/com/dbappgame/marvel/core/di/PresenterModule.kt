package com.dbappgame.marvel.core.di

import com.dbappgame.marvel.presentation.presenter.CharactersPresenter
import com.dbappgame.marvel.presentation.presenter.CharactersPresenterImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent


@Module
@InstallIn(FragmentComponent::class)
abstract class PresenterModule {

    @Binds
    abstract fun bindPresenter(imp: CharactersPresenterImp): CharactersPresenter

}


