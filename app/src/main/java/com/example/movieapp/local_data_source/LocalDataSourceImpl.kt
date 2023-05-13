package com.example.movieapp.local_data_source

class LocalDataSourceImpl private constructor(val movieDAO: MovieDAO):LocalDataSource {

    companion object{
        private  var localSource:LocalDataSource?=null
        fun getInstance(movieDAO: MovieDAO):LocalDataSource{
            if(localSource==null)
            {
                localSource=LocalDataSourceImpl(movieDAO)
            }
            return localSource as LocalDataSource
        }
    }
}