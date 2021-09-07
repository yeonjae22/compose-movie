package com.example.movie.data.repository

import com.example.movie.data.source.MovieRemoteDataSource
import com.example.movie.model.Movie
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val remoteDataSource: MovieRemoteDataSource) :
    MovieRepository {
    override fun getMovieList(query: String, start: Int): Single<Movie> =
        remoteDataSource.getMovieList(query, start)
}