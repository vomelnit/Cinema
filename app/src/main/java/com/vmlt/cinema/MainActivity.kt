package com.vmlt.cinema

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vmlt.cinema.ui.theme.CinemaTheme
import com.vmlt.cinema.ui.theme.MovieCardColor
import com.vmlt.cinema.MainContract.MainView

class MainActivity : ComponentActivity(), MainView, MovieDetailedInfoActivityStarter {
    private lateinit var mainPresenter: MainContract.MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setMainContent(mainPresenter.getEntireMovieList(), this)
        }

        mainPresenter = MainPresenter(this, MovieModel())
    }

    override fun updateMovieRating() {
        TODO("Not yet implemented")
    }

    override fun removeMovieFromList() {
        TODO("Not yet implemented")
    }

    override fun startActivityForMovie(movieName: String) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra("MovieName", movieName)
        startActivity(intent)
    }
}


@Composable
fun setMainContent(movies: List<MovieBasicInfo>, movieActivity: MovieDetailedInfoActivityStarter) {
    CinemaTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            MovieList(movies, movieActivity)
        }
    }
}

@Composable
fun MovieList(movies: List<MovieBasicInfo>, movieActivity: MovieDetailedInfoActivityStarter) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, top = 30.dp, end = 30.dp, bottom = 30.dp)
    ) {
        items(items = movies, itemContent = { item ->
            MovieBasicInfoElement(item, movieActivity)
        })
    }
}

@Composable
fun MovieBasicInfoElement(movie: MovieBasicInfo, movieActivity: MovieDetailedInfoActivityStarter) {
    Card(
        modifier = Modifier
            .padding(vertical = 10.dp).clickable {
                movieActivity.startActivityForMovie(movie.name)
            },
        backgroundColor = MovieCardColor,
        contentColor = MovieCardColor,
        border = BorderStroke(width = 1.dp, color = Color.Gray),
        shape = RoundedCornerShape(25.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(id = movie.iconId),
                contentDescription = "poster",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(horizontal = 15.dp)
                    .size(200.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.padding(top = 20.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(end = 35.dp),
                        text = movie.year.toString(),
                        color = Color.Black
                    )
                    Text(
                        modifier = Modifier.padding(start = 35.dp),
                        text = movie.rating.toString(),
                        color = Color.Black
                    )
                }
                Text(
                    modifier = Modifier
                        .padding(top = 40.dp)
                        .fillMaxHeight(0.6f),
                    text = movie.name,
                    fontSize = 24.sp,
                    color = Color.Black
                )
            }
        }

    }
}
