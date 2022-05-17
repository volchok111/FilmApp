package com.example.films.ui.first

import android.os.Bundle
import android.view.*
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.films.R
import com.example.films.adapter.Adapter
import com.example.films.databinding.FragmentFirstBinding
import com.example.films.model.MovieModel
import com.example.films.ui.home.HomeFragment

class FirstFragment : HomeFragment(),FirstView {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy { Adapter() }

    @InjectPresenter
    lateinit var firstPresenter: FirstPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        _binding = FragmentFirstBinding.inflate(layoutInflater)
        binding.recyclerView.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let { firstPresenter.startInitialization(it) }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
       inflater.inflate(R.menu.sort_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.sorting_title_az -> adapter.doSortByTitleAz()
                .also { Toast.makeText(context, "Sorted by titles A-Z", Toast.LENGTH_SHORT).show() }
            R.id.sorting_title_za -> adapter.doSortByTitleZa()
                .also { Toast.makeText(context, "Sorted by titles Z-A", Toast.LENGTH_SHORT).show() }
            R.id.sorting_votes -> adapter.doSortByVotes100()
                .also { Toast.makeText(context, "Sorted by votes 10-0", Toast.LENGTH_SHORT).show() }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onListSetup(movies: List<MovieModel>) {
        adapter.newList(movies as ArrayList<MovieModel> /* = java.util.ArrayList<com.example.films.model.MovieModel> */)
    }

    override fun addMovie(movie: MovieModel) {
        adapter.addList(movie)
    }

    override fun onDestroyView() {
        _binding = null
        firstPresenter.dispose()
        super.onDestroyView()
    }

}