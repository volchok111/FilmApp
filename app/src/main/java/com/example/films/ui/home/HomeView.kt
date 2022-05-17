package com.example.films.ui.home

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface HomeView: MvpView {
    fun onRequestStart()
    fun onRequestComplete()
    fun onRequestError(message: Int)
    fun onConnectionAbsence()
}