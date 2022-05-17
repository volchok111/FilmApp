package com.example.films.api

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.films.model.Movie
import com.example.films.model.MovieModel
import com.example.films.network.HttpRetrofit
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ApiServiceImpl: ApiService {
    private val httpRetrofit: HttpRetrofit = HttpRetrofit



    override fun hasPing(context: Context): Boolean {
        /* Getting the connectivity manager service from the context. */
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val nw = manager.activeNetwork ?: return false
        val actNw = manager.getNetworkCapabilities(nw)
        if (actNw != null) {
            /* Checking if the device has a wifi or cellular connection. */
            return actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
        }
        return true
    }

    override fun getMovie(): Observable<Movie> {
        return httpRetrofit.getHttpApi().getMovies()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getMovieById(id: Int): Observable<MovieModel> {
        return httpRetrofit.getHttpApi().getMovieById(id)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
    }

}