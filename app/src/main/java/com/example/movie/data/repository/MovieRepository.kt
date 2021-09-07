package com.example.movie.data.repository

import com.example.movie.model.Movie
import io.reactivex.rxjava3.core.Single

interface MovieRepository {
    fun getMovieList(query: String, start: Int): Single<Movie>
}