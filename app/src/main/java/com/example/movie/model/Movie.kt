package com.example.movie.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("items")
    val items: List<MovieItem>,
)

data class MovieItem(
    @SerializedName("title")
    val title: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("pubDate")
    val pubDate: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("actor")
    val actor: String,
    @SerializedName("userRating")
    val userRating: Double
)