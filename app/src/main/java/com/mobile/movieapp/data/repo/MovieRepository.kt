package com.mobile.movieapp.data.repo

import com.mobile.movieapp.data.datasource.MovieDataSource
import com.mobile.movieapp.data.entity.Movies

class MovieRepository {

    var mds = MovieDataSource()

    suspend fun loadMovies() : List<Movies> = mds.loadMovies()
}