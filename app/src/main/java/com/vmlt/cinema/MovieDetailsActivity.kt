package com.vmlt.cinema

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MovieDetailsActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movieName = intent.getStringExtra("MovieName")
        Log.i("MovieDetailsActivity", "movieName = $movieName");
        setContent {
        }
    }
}