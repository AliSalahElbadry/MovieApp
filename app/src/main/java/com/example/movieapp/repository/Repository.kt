package com.example.movieapp.repository

import com.example.movieapp.local_data_source.LocalDataSource
import com.example.movieapp.model.MovieResponce
import com.example.movieapp.remote_data_source.RemoteDataSource
import kotlinx.coroutines.flow.Flow

class Repository(private val localDataSource:LocalDataSource,private val remoteDataSource: RemoteDataSource):IRepository {
    override suspend fun get250Movies(): Flow<MovieResponce> {
        return  remoteDataSource.get250Movies()
    }
}