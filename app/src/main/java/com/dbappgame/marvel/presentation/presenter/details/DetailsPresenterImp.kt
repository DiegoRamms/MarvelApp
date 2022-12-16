package com.dbappgame.marvel.presentation.presenter.details

import com.dbappgame.marvel.domain.model.BaseResult
import com.dbappgame.marvel.domain.repository.MarvelRepository
import com.dbappgame.marvel.presentation.presenter.character.CharactersPresenter
import com.dbappgame.marvel.presentation.view.charecter.CharactersView
import com.dbappgame.marvel.presentation.view.details.DetailsView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
