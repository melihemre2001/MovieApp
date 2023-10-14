package com.mobile.movieapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.mobile.movieapp.R
import com.mobile.movieapp.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)

        val bundle: DetailFragmentArgs by navArgs()
        val movie = bundle.movie

        binding.movieObject = movie

        binding.imageViewMovie.setImageResource(
            resources.getIdentifier(movie.image,"drawable",requireContext().packageName))

        binding.textViewPrice.text = "${movie.price}₺"

        return binding.root
    }


}