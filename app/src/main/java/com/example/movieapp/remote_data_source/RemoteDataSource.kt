package com.example.movieapp.remote_data_source

import com.example.movieapp.model.MovieResponce
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun get250Movies():Flow<MovieResponce>
}