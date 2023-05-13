package com.example.movieapp.movie_show.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.model.Item
import com.example.movieapp.repository.IRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieShowViewModel(private val repository: IRepository):ViewModel() {

     private var _movies:MutableLiveData<List<Item>> = MutableLiveData()
     val movies:LiveData<List<Item>> = _movies
     fun loadMovies(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.get250Movies().collect {
            withContext(Dispatchers.Main) {
                _movies.value = it.items
            }

            }
        }
    }
}