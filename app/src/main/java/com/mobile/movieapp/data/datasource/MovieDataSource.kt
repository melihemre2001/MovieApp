package com.mobile.movieapp.data.datasource

import com.mobile.movieapp.data.entity.Movies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieDataSource {
    suspend fun loadMovies() : List<Movies> =
        withContext(Dispatchers.IO){
            val movieList = ArrayList<Movies>()
            val f1 = Movies(1,"Django","django",24)
            val f2 = Movies(2,"Interstellar","interstellar",32)
            val f3 = Movies(3,"Inception","inception",16)
            val f4 = Movies(4,"The Hateful Eight","thehatefuleight",28)
            val f5 = Movies(5,"The Pianist","thepianist",18)
            val f6 = Movies(6,"Anadoluda","anadoluda",10)
            movieList.add(f1)
            movieList.add(f2)
            movieList.add(f3)
            movieList.add(f4)
            movieList.add(f5)
            movieList.add(f6)
            return@withContext movieList
    }
}