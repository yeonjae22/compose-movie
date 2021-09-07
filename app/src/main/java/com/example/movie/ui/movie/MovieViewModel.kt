package com.example.movie.ui.movie

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movie.data.repository.MovieRepository
import com.example.movie.model.MovieItem
import com.example.movie.ui.components.MovieList
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val _movieList = MutableLiveData<List<MovieItem>>()
    val movieList: LiveData<List<MovieItem>>
        get() = _movieList

    fun getMovieList(query: String, start: Int) {
        compositeDisposable.add(
            repository.getMovieList(query, start)
                .map {
                    it.items
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _movieList.value = it
                }, {
                    Log.d("getMovieList", it.toString())
                })
        )
    }
}

@Composable
fun ExampleScreen(
    viewModel: MovieViewModel = viewModel()
) {
    viewModel.getMovieList("겨울", 1)

    val movieList = viewModel.movieList.observeAsState()
    movieList.value?.let { MovieList(it) }
}

