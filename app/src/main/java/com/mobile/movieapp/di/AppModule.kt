package com.mobile.movieapp.di

import com.mobile.movieapp.data.datasource.MovieDataSource
import com.mobile.movieapp.data.repo.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideMovieDataSource() : MovieDataSource {
        return MovieDataSource()
    }
    @Provides
    @Singleton
    fun provideMovieRepository(mds: MovieDataSource) : MovieRepository {
        return MovieRepository(mds)
    }
}