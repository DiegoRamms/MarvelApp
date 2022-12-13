package com.dbappgame.marvel.core.di

import com.dbappgame.marvel.data.repository.MarvelRepositoryImp
import com.dbappgame.marvel.domain.repository.MarvelRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
abstract class RepositoryModule  {

    @Binds
    abstract fun bindMarvelRepository(marvelRepositoryImp: MarvelRepositoryImp): MarvelRepository

}