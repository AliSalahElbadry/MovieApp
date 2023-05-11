package com.example.movieapp.movie_show.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.repository.IRepository

class MovieShowViewModelFactory(private val repository: IRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(MovieShowViewModel::class.java)){
            MovieShowViewModel(repository) as T
        }else{
            throw java.lang.IllegalArgumentException()
        }
    }
}