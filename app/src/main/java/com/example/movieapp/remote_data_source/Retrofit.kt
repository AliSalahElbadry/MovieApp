package com.example.movieapp.remote_data_source

import com.example.movieapp.Constants
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
object Retrofit  {
    private val cacheClient=OkHttpClient.Builder().build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(Constants.top250MovieUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(cacheClient)
        .build()
    val myService: MovieApiService = retrofit.create(MovieApiService::class.java)
}