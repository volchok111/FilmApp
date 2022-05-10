package com.example.films.model

data class Movie(
    val dates: Dates,
    val page: Int,
    val results: List<MovieModel>,
    val total_pages: Int,
    val total_results: Int
)