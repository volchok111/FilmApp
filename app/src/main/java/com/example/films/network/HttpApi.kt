package com.example.films.network

import com.example.films.model.Movie
import com.example.films.model.MovieModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface HttpApi {
    @GET("3/movie/now_playing?api_key=41c216b15a72be8a791715a6d9a569ca&language=en-US&page=1")
    fun getMovies(): Observable<Movie>

    @GET("/movie/{movie_id}")
    fun getMovieById(@Path("movie_id")id: Int): Observable<MovieModel>
}