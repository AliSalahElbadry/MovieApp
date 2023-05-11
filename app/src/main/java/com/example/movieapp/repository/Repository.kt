package com.example.movieapp.repository

import com.example.movieapp.local_data_source.LocalDataSource
import com.example.movieapp.remote_data_source.RemoteDataSource

class Repository(private val localDataSource:LocalDataSource,private val remoteDataSource: RemoteDataSource):IRepository {

}