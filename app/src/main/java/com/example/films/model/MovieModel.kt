package com.example.films.model

import java.io.Serializable

data class MovieModel(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
): Serializable{

    companion object{
        val sortByNameAz = object : Comparator<MovieModel>{
            override fun compare(o1: MovieModel?, o2: MovieModel?): Int {
                if (o1 != null && o2 != null)
                    return o1.title.compareTo(o2.title)
                return 0
            }
        }

        val sortByNameZa = object : Comparator<MovieModel>{
            override fun compare(o1: MovieModel?, o2: MovieModel?): Int {
                if (o1 != null && o2 != null)
                    return o2.title.compareTo(o1.title)
                return 0
            }
        }


        val sortByVotes = object : Comparator<MovieModel>{
            override fun compare(o1: MovieModel?, o2: MovieModel?): Int {
                if (o1 != null && o2 != null)
                    return o2.vote_average.compareTo(o1.vote_average)
                return 0
            }
        }


    }

}