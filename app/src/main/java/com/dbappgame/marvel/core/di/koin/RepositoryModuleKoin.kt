package com.dbappgame.marvel.core.di.koin

import com.dbappgame.marvel.data.repository.MarvelRepositoryImp
import com.dbappgame.marvel.domain.repository.MarvelRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::MarvelRepositoryImp){
        bind<MarvelRepository>()
    }
}