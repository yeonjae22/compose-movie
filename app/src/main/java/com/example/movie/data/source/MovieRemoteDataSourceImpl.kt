package com.example.movie.data.source

import com.example.movie.model.Movie
import com.example.movie.network.MovieService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(private val movieService: MovieService) :
    MovieRemoteDataSource {
    override fun getMovieList(query: String, start: Int): Single<Movie> {
        return movieService.getMovieList(
            "3NuWfpAkZ7VoEB3xdyhr",
            "iu6rVhn43J",
            query,
            start
        )
    }
}