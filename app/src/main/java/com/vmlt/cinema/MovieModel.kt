package com.vmlt.cinema

class MovieModel {
    private val movieList: List<Movie> = generateMoviesList()

    fun getAllAvailableMoviesBasicInfo(): List<MovieBasicInfo> {
        var movieBasicInfoList: List<MovieBasicInfo> = mutableListOf()
        movieList.forEach {
                movie ->  movieBasicInfoList += MovieBasicInfo(movie.name, movie.rating, movie.iconId, movie.year)
        }

        return movieBasicInfoList
    }

    private fun generateMoviesList(): List<Movie> {
        return listOf(
            Movie("The Strays", 6.5f, R.drawable.the_strays_poster, 2023, "Thriller"),
            Movie("The Whale", 7.7f, R.drawable.the_whale_poster, 2022, "Drama"),
            Movie("All that breathes", 6.5f, R.drawable.all_that_breathes_poster, 2010, "Horror"),
            Movie("We have a ghost", 3.3f, R.drawable.we_have_a_ghost_poster, 2018, "Comedy"),
            )
    }
}