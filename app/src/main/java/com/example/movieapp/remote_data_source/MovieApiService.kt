package com.example.movieapp.remote_data_source

import com.example.movieapp.model.MovieResponce
import retrofit2.http.GET

interface MovieApiService {

    @GET("en/API/Top250Movies/k_njr8180d")
    suspend fun getMovies():MovieResponce
}