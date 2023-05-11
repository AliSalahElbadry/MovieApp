package com.example.movieapp.remote_data_source

import com.example.movieapp.Constants
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
object Retrofit  {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(Constants.top250MovieUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val myService: MovieApiService = retrofit.create(MovieApiService::class.java)
}