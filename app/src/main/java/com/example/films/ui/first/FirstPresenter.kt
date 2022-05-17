package com.example.films.ui.first

import android.content.Context
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.films.R
import com.example.films.api.ApiServiceImpl
import com.example.films.model.MovieModel
import io.reactivex.disposables.CompositeDisposable

@InjectViewState
class FirstPresenter : MvpPresenter<FirstView>() {
    private val apiService = ApiServiceImpl()
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()


    fun startInitialization(context: Context) {
        if (dataList.isNotEmpty()) {
            viewState.onListSetup(dataList)
            return
        }
        context.let {
            if (!apiService.hasPing(context)) {
                viewState.onConnectionAbsence()
            }
        }
        compositeDisposable.add(
            apiService.getMovie()
                .subscribe({ movie ->
                    viewState.onListSetup(movie.results)
                },
                {viewState.onRequestError(R.string.error)})
        )
    }

    fun dispose(){
        compositeDisposable.dispose()
    }

    companion object {
        private val dataList = ArrayList<MovieModel>()
    }
}