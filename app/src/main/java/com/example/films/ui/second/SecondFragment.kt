package com.example.films.ui.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.films.MainActivity
import com.example.films.R
import com.example.films.databinding.FragmentSecondBinding
import com.example.films.model.MovieModel
import com.example.films.ui.home.HomeFragment
import com.squareup.picasso.Picasso

class SecondFragment : HomeFragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private lateinit var movie: MovieModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movie = arguments?.getSerializable("movie_model") as MovieModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(layoutInflater)
        Picasso.get().load("${BASE_URL}${movie.poster_path}").into(binding.secondFragmentIv)
        binding.fragmentSecondTitleTv.text = movie.title
        binding.fragmentSecondDescriptionTv.text = movie.overview
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

companion object{
    private const val BASE_URL = "https://image.tmdb.org/t/p/w500"
}
}