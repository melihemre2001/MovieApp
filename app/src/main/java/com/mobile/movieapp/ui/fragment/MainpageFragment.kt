package com.mobile.movieapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mobile.movieapp.R
import com.mobile.movieapp.data.entity.Movies
import com.mobile.movieapp.databinding.FragmentMainpageBinding
import com.mobile.movieapp.ui.adapter.MoviesAdapter


class MainpageFragment : Fragment() {

    private lateinit var binding : FragmentMainpageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainpageBinding.inflate(inflater,container,false)

        binding.toolbarMainpage.title = "Movies"

        binding.movieRecyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

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

        val moviesAdapter = MoviesAdapter(requireContext(),movieList)
        binding.movieRecyclerView.adapter = moviesAdapter



        return binding.root
    }


}