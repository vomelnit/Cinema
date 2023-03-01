package com.vmlt.cinema

interface MainContract {
    interface MainView {
        fun updateMovieRating()
        fun removeMovieFromList()
    }

    interface MainPresenter {
        fun getEntireMovieList(): List<MovieBasicInfo>
        fun getFavouriteMovieList(): List<MovieBasicInfo>
        fun refreshMovieData()
    }
}