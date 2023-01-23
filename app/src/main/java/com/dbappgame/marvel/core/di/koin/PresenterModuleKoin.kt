package com.dbappgame.marvel.core.di.koin

import com.dbappgame.marvel.presentation.presenter.character.CharactersPresenter
import com.dbappgame.marvel.presentation.presenter.character.CharactersPresenterImp
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val presenterModule = module {
    singleOf(::CharactersPresenterImp){
        bind<CharactersPresenter>()
    }
}