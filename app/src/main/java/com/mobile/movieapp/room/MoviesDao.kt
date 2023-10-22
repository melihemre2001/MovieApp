package com.mobile.movieapp.room

import androidx.room.Dao
import androidx.room.Query
import com.mobile.movieapp.data.entity.Movies

@Dao
interface MoviesDao {
    @Query("SELECT * FROM movies")
    suspend fun loadMovies() : List<Movies>
}