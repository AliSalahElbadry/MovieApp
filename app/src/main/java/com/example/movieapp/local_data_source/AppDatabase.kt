package com.example.movieapp.local_data_source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movieapp.model.Item

@Database(entities = [Item::class], version =1 )
abstract class AppDataBase: RoomDatabase() {
 abstract fun getMovieDao(): MovieDAO
 companion object{
  @Volatile
  private var INSTANCE: AppDataBase? = null
  fun getInstance(ctx: Context): AppDataBase{
   return INSTANCE ?: synchronized(this) {
    val instance = Room.databaseBuilder(ctx.applicationContext, AppDataBase::class.java, "movie_database").build()
    INSTANCE = instance
    return instance
   }
  }
 }
}