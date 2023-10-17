package com.mobile.movieapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mobile.movieapp.R
import com.mobile.movieapp.data.entity.Movies
import com.mobile.movieapp.databinding.FragmentMainpageBinding
import com.mobile.movieapp.ui.adapter.MoviesAdapter
import com.mobile.movieapp.ui.viewmodel.MainpageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainpageFragment : Fragment() {

    private lateinit var binding : FragmentMainpageBinding
    private lateinit var viewModel: MainpageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : MainpageViewModel by viewModels()
        viewModel = tempViewModel
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_mainpage,container,false)

        binding.mainpageToolbarTitle = "Movies"

        viewModel.movieList.observe(viewLifecycleOwner){
            val moviesAdapter = MoviesAdapter(requireContext(),it)
            binding.moviesAdapter = moviesAdapter
        }
        return binding.root
    }


}