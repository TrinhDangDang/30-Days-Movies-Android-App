package com.example.days

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.DaysTheme
import com.example.days.data.Movie
import com.example.days.data.MoviesDataSource.movies

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DaysTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    DaysOfMoviesApp()
                }
            }
        }
    }
}

@Composable
fun DaysOfMoviesApp (modifier: Modifier = Modifier) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Scaffold (
       topBar = {
            DaysTopAppBar()
        }
    ) {
        innerPadding ->
        LazyColumn (contentPadding = innerPadding) {
            items(movies) { movie ->
                MovieItem(
                    movie,
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .width(screenWidth)
                )
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie, modifier: Modifier = Modifier){
    Card(
        modifier = modifier
    ) {
        Column( modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Day ${movie.day}",
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    text = stringResource(movie.movieNameRes),
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            Image(
                painter = painterResource(movie.movieImageRes),
                contentDescription = stringResource(movie.movieNameRes),
                modifier = Modifier
                    .size(500.dp)
                    .padding(20.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaysTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "30 days movies",
                style = MaterialTheme.typography.displaySmall
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DaysTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            DaysOfMoviesApp()
        }

    }
}