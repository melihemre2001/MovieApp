package com.mobile.movieapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mobile.movieapp.R
import com.mobile.movieapp.data.entity.Movies
import com.mobile.movieapp.databinding.CardDesignBinding
import com.mobile.movieapp.ui.fragment.MainpageFragment
import com.mobile.movieapp.ui.fragment.MainpageFragmentDirections

class MoviesAdapter(var mContext:Context,var movieList: List<Movies>) : RecyclerView.Adapter<MoviesAdapter.CardDesignHolder>(){

    inner class CardDesignHolder(var design: CardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding:CardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_design ,parent,false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val movie = movieList[position]
        val t = holder.design

        t.imageViewMovie.setImageResource(
            mContext.resources.getIdentifier(movie.image,"drawable",mContext.packageName))
        t.movieObject = movie

        t.cardViewMovie.setOnClickListener {
            val action = MainpageFragmentDirections.actionMainpageFragmentToDetailFragment(movie = movie)
            Navigation.findNavController(it).navigate(action)
        }

        t.buttonCart.setOnClickListener {
            Snackbar.make(it,"${movie.name} added to cart",Snackbar.LENGTH_LONG)
                .show()
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}