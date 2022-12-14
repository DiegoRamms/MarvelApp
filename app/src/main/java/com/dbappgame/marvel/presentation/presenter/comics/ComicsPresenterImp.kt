package com.dbappgame.marvel.presentation.presenter.comics

import com.dbappgame.marvel.domain.model.BaseResult
import com.dbappgame.marvel.domain.model.Comic
import com.dbappgame.marvel.domain.repository.MarvelRepository
import com.dbappgame.marvel.presentation.view.comics.ComicsView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

