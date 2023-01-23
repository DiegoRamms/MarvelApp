package com.dbappgame.marvel.core.di.daggerhilt

import com.dbappgame.marvel.data.repository.MarvelRepositoryImp
import com.dbappgame.marvel.domain.repository.MarvelRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent
import org.koin.core.module.dsl.singleOf
import javax.inject.Singleton
import org.koin.dsl.module

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule  {

    @Binds
    @Singleton
    abstract fun bindMarvelRepository(marvelRepositoryImp: MarvelRepositoryImp): MarvelRepository

}