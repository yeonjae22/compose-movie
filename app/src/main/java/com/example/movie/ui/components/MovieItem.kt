package com.example.movie.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.movie.R
import com.example.movie.model.MovieItem

@Composable
fun MovieList(movies: List<MovieItem>) {
    LazyColumn {
        items(movies) { movie ->
            MovieItem(movie)
        }
    }
}

@Composable
fun MovieItem(movie: MovieItem) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 0.dp,
        backgroundColor = Color.White
    ) {
        Row {
            MovieImage(movie)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp, 0.dp, 0.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = movie.title.replace("<b>", "")
                        .replace("</b>", "") + " (" + movie.pubDate + ")",
                    fontSize = 14.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_baseline_star_16),
                        contentDescription = null
                    )
                    Text(
                        text = movie.userRating.toString(),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(2.dp, 0.dp, 0.dp, 0.dp)
                    )
                }
                Text(text = "감독 " + movie.director.replace("|", ""), fontSize = 12.sp)
                var actor = movie.actor
                if (movie.actor.endsWith("|")) {
                    actor = movie.actor.substring(0, movie.actor.length - 1)
                }
                Text(text = "출연 " + actor.replace("|", ", "), fontSize = 12.sp)
            }
        }
    }
}

@Composable
private fun MovieImage(movie: MovieItem) {
    Image(
        painter = rememberImagePainter(movie.image),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(4.dp)))
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMovieList() {
    MovieList(
        arrayListOf(
            MovieItem(
                "겨울왕국",
                "",
                "",
                "2021",
                "연재",
                "이연재",
                5.0
            )
        )
    )
}
