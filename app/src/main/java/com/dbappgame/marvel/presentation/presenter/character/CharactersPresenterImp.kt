package com.dbappgame.marvel.presentation.presenter.character

import android.util.Log
import com.dbappgame.marvel.domain.model.BaseResult
import com.dbappgame.marvel.domain.model.Comic
import com.dbappgame.marvel.domain.model.MarvelCharacter
import com.dbappgame.marvel.domain.repository.MarvelRepository
import com.dbappgame.marvel.presentation.view.charecter.CharactersView
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
        disposable = repository.getCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { value ->
                    when (value) {
                        is BaseResult.Success -> {

                            view.setData(value.data)
                        }
                        is BaseResult.Error -> view.showError(value.message)
                    }
                    view.loadView(false)
                },
                { throwable ->
                    view.showError(throwable.message.toString())
                    view.loadView(false)
                }
            )

        disposable?.let { CompositeDisposable().add(it) }
    }

    override fun onDestroy() {
        disposable?.dispose()
    }

}





