package com.vmlt.cinema

import java.lang.ref.WeakReference

class MainPresenter(private var mainView: MainContract.MainView, val movieModel: MovieModel) :
    MainContract.MainPresenter {

    val mainViewReference: WeakReference<MainContract.MainView> = WeakReference(mainView)

    override fun getEntireMovieList(): List<MovieBasicInfo> {
        return movieModel.getAllAvailableMoviesBasicInfo()
    }

    override fun getFavouriteMovieList(): List<MovieBasicInfo> {
        TODO("Not yet implemented")
    }

    override fun refreshMovieData() {
        TODO("Not yet implemented")
    }

}