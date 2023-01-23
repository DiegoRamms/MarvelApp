package com.dbappgame.marvel.core.di.koin

import androidx.fragment.app.Fragment
import com.dbappgame.marvel.presentation.view.charecter.CharacterFragment
import com.dbappgame.marvel.presentation.view.charecter.CharactersView
import dagger.Binds
import org.koin.androidx.fragment.dsl.fragment
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val fragmentModule = module {
    single<CharactersView>{ get<CharacterFragment>()}
    single{ CharacterFragment.newInstance() }
}
