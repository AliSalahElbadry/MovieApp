package com.example.movieapp.model

data class MovieResponce(
    val errorMessage: String,
    val items: List<Item>
)