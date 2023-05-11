package com.example.movieapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Movie")
data class Item(
    var crew: String,
    var fullTitle: String,
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = false)
    var id: String,
    var imDbRating: String,
    var imDbRatingCount: String,
    var image: String,
    var rank: String,
    var title: String,
    var year: String
)