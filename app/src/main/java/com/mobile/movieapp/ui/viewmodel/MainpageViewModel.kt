package com.mobile.movieapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.movieapp.data.entity.Movies
import com.mobile.movieapp.data.repo.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainpageViewModel : ViewModel() {
    var mrepo = MovieRepository()
    var movieList = MutableLiveData<List<Movies>>()

    init{
        loadMovies()
    }

    fun loadMovies(){
        CoroutineScope(Dispatchers.Main).launch {
            movieList.value = mrepo.loadMovies()
        }
    }
}