package com.example.films.api

import android.content.Context
import com.example.films.model.Movie
import com.example.films.model.MovieModel
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    fun hasPing(context: Context): Boolean
    fun getMovie(): Observable<Movie>
    fun getMovieById(id: Int): Observable<MovieModel>



}
