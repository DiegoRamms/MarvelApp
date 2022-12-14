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

class ComicsPresenterImp @Inject constructor(
    private val comicsView: ComicsView,
    private val repository: MarvelRepository
) : ComicsPresenter {
    var disposable: Disposable? = null
    override fun getData(characterId: Int) {
        comicsView.showError("Hola")
        disposable = repository.getComics(characterId).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe ({result -> when(result){
                is BaseResult.Success -> comicsView.setData(result.data)
                is BaseResult.Error -> comicsView.showError(result.message)
            } },{
                comicsView.showError(it.toString())
            } )

        disposable?.let { CompositeDisposable().add(it) }
    }

    override fun onDestroy() {
        disposable?.dispose()
    }
}