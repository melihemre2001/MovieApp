package com.mobile.movieapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.movieapp.data.entity.Movies
import com.mobile.movieapp.data.repo.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainpageViewModel @Inject constructor(var mrepo : MovieRepository): ViewModel() {
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