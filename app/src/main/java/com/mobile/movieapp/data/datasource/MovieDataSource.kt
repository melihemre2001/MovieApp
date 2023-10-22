package com.mobile.movieapp.data.datasource

import com.mobile.movieapp.data.entity.Movies
import com.mobile.movieapp.room.MoviesDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieDataSource(var moviesDao: MoviesDao) {
    suspend fun loadMovies() : List<Movies> =
        withContext(Dispatchers.IO){

            return@withContext moviesDao.loadMovies()
    }
}