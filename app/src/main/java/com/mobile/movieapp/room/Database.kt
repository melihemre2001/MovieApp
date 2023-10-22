package com.mobile.movieapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mobile.movieapp.data.entity.Movies

@Database(entities = [Movies::class] , version = 1)
abstract class Database : RoomDatabase(){
    abstract fun getMoviesDao() : MoviesDao
}