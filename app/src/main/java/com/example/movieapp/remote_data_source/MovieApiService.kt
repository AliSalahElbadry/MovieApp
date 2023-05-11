package com.example.movieapp.remote_data_source

import retrofit2.http.GET

interface MovieApiService {

    @GET
    suspend fun getMovies()
}