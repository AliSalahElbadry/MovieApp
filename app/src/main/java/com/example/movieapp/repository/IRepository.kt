package com.example.movieapp.repository

import com.example.movieapp.local_data_source.LocalDataSource
import com.example.movieapp.remote_data_source.RemoteDataSource

interface IRepository:LocalDataSource,RemoteDataSource {
}