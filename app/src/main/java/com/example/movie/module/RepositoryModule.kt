package com.example.movie.module

import com.example.movie.data.repository.MovieRepository
import com.example.movie.data.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindMovieRepo(
        movieRepositoryImpl: MovieRepositoryImpl
    ): MovieRepository
}