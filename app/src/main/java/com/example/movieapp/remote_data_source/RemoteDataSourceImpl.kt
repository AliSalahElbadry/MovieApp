package com.example.movieapp.remote_data_source

import com.example.movieapp.model.MovieResponce
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl private constructor():RemoteDataSource {
    private val myService=Retrofit.myService
    override suspend fun get250Movies(): Flow<MovieResponce> {
       return flow{
           emit(myService.getMovies())
       }
    }
    companion object{
        private  var remoteSource:RemoteDataSource?=null
        fun getInstance():RemoteDataSource{
            if(remoteSource==null)
            {
                remoteSource=RemoteDataSourceImpl()
            }
            return remoteSource as RemoteDataSource
        }
    }
}



