package com.dbappgame.marvel.presentation.presenter

import com.dbappgame.marvel.domain.model.BaseResult
import com.dbappgame.marvel.domain.repository.MarvelRepository
import com.dbappgame.marvel.presentation.view.CharactersView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CharactersPresenterImp @Inject constructor(
    private val view: CharactersView,
    private val repository: MarvelRepository
) : CharactersPresenter {

    private var disposable: Disposable? = null

    override fun getData() {

        view.loadView(true)
        val disposable = repository.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { value ->
                    when (value) {
                        is BaseResult.Success -> view.showList(value.data)
                        is BaseResult.Error -> view.showError(value.message)
                    }
                    view.loadView(false)
                },
                { throwable ->
                    view.showError(throwable.message.toString())
                    view.loadView(false)
                }
            )

        CompositeDisposable().add(disposable)
    }

    override fun onDestroy() {
        disposable?.dispose()
    }

}





