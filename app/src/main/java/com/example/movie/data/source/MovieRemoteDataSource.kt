package com.example.movie.data.source

import com.example.movie.model.Movie
import io.reactivex.rxjava3.core.Single

interface MovieRemoteDataSource {
    fun getMovieList(query: String, start: Int): Single<Movie>
}