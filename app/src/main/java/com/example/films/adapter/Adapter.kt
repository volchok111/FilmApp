package com.example.films.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.films.R
import com.example.films.model.Movie
import com.example.films.model.MovieModel
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

class Adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var movieList = arrayListOf<MovieModel>()

    fun newList(list: ArrayList<MovieModel>){
        movieList = list
        notifyDataSetChanged()
    }

    fun addList(movie: MovieModel){
        movieList.add(movie)
        notifyDataSetChanged()
    }

    fun doSortByTitleAz(){
        Collections.sort(movieList, MovieModel.sortByNameAz)
        notifyDataSetChanged()
    }

    fun doSortByTitleZa(){
        Collections.sort(movieList, MovieModel.sortByNameZa)
        notifyDataSetChanged()
    }

    fun doSortByVotes100(){
        Collections.sort(movieList,MovieModel.sortByVotes)
        notifyDataSetChanged()
    }

    class FilmViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val image = view.findViewById<ImageView>(R.id.item_iv)
        private val title = view.findViewById<TextView>(R.id.item_title)
        private val averageVotes = view.findViewById<TextView>(R.id.item_vote_average)
        private val date = view.findViewById<TextView>(R.id.item_date)


        fun bind(movie: MovieModel){
            val baseUrl = "https://image.tmdb.org/t/p/w500"
            Picasso.get().load(baseUrl + movie.poster_path).into(image)
            title.text = movie.title
            averageVotes.text = movie.vote_average.toString()
            date.text = movie.release_date
            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putSerializable("movie_model", movie)
                itemView.findNavController().navigate(
                    R.id.action_firstFragment_to_secondFragment,bundle
                )
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return FilmViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FilmViewHolder)
            holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.count()
    }
}