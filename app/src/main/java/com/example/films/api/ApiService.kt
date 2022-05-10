package com.example.films.api

import com.example.films.model.Movie
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("3/movie/now_playing?api_key=41c216b15a72be8a791715a6d9a569ca&language=en-US&page=1")
    fun getMovies(): Response<Movie>
}
