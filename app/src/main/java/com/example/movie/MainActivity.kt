package com.example.movie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movie.ui.movie.ExampleScreen
import com.example.movie.ui.movie.MovieViewModel
import com.example.movie.ui.theme.MovieTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MovieTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val viewModel = hiltViewModel<MovieViewModel>()
                    ExampleScreen(viewModel)
                }
            }
        }
    }
}