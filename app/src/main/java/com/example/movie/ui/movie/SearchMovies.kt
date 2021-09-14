package com.example.movie.ui.movie

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movie.R

@Composable
fun SearchMovies() {
    var text by remember { mutableStateOf("") }
    val viewModel = hiltViewModel<MovieViewModel>()
    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp, 16.dp, 24.dp, 8.dp),
        textStyle = TextStyle(color = Color.Black),
        placeholder = { Text(text = "영화 제목을 검색해보세요.") },
        trailingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_baseline_search_24),
                contentDescription = null,
                modifier = Modifier.clickable {
                    viewModel.getMovieList(text, 1)
                }
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color.White,
            focusedBorderColor = Color.Gray
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchMovies() {
    SearchMovies()
}