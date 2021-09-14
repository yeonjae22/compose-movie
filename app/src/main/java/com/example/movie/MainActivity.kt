package com.example.movie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.movie.ui.components.SearchMovies
import com.example.movie.ui.movie.MovieScreen
import com.example.movie.ui.theme.MovieTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MovieTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        SearchMovies()
                        MovieScreen()
                    }
                }
            }
        }
    }
}