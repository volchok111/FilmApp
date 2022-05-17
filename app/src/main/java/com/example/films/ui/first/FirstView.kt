package com.example.films.ui.first

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.films.model.Movie
import com.example.films.model.MovieModel
import com.example.films.ui.home.HomeView

@StateStrategyType(SingleStateStrategy::class)
interface FirstView: HomeView{
    fun onListSetup(movies: List<MovieModel>)
    fun addMovie(movie: MovieModel)


}