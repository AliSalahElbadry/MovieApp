package com.example.movieapp.movie_show.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMovieShowBinding
import com.example.movieapp.local_data_source.AppDataBase
import com.example.movieapp.local_data_source.LocalDataSourceImpl
import com.example.movieapp.model.Item
import com.example.movieapp.movie_show.viewmodel.MovieShowViewModel
import com.example.movieapp.movie_show.viewmodel.MovieShowViewModelFactory
import com.example.movieapp.remote_data_source.RemoteDataSourceImpl
import com.example.movieapp.repository.Repository
import kotlinx.coroutines.launch

class MovieShowFragment : Fragment() {

    private  var movieShowAdapter: MovieShowAdapter?=null
    lateinit var movieShowViewModel: MovieShowViewModel
    private lateinit var binding: FragmentMovieShowBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         binding=FragmentMovieShowBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory=MovieShowViewModelFactory(
            Repository(LocalDataSourceImpl.getInstance(AppDataBase.getInstance(requireContext()).getMovieDao()),RemoteDataSourceImpl.getInstance())
        )
        movieShowViewModel=ViewModelProvider(this,factory)[MovieShowViewModel::class.java]
        movieShowAdapter= MovieShowAdapter()
        movieShowAdapter?.movieList= mutableListOf<Item>()
        binding.moviesRecycleView.layoutManager=LinearLayoutManager(requireContext())
        binding.moviesRecycleView.adapter=movieShowAdapter
        movieShowViewModel.loadMovies()
        movieShowViewModel.movies.observe(viewLifecycleOwner, Observer {
            movieShowAdapter?.movieList=it
            movieShowAdapter?.notifyDataSetChanged()
        })
    }

    override fun onDestroyView() {
        movieShowAdapter=null
        super.onDestroyView()
    }

}