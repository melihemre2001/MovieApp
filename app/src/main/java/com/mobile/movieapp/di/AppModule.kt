package com.mobile.movieapp.di

import android.content.Context
import android.provider.ContactsContract.Data
import androidx.room.Room
import com.mobile.movieapp.data.datasource.MovieDataSource
import com.mobile.movieapp.data.repo.MovieRepository
import com.mobile.movieapp.room.Database
import com.mobile.movieapp.room.MoviesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideMovieDataSource(moviesDao: MoviesDao) : MovieDataSource {
        return MovieDataSource(moviesDao)
    }
    @Provides
    @Singleton
    fun provideMovieRepository(mds: MovieDataSource) : MovieRepository {
        return MovieRepository(mds)
    }

    @Provides
    @Singleton
    fun provideMovieDataSource(@ApplicationContext context: Context) : MoviesDao {
        val vt = Room.databaseBuilder(context,Database::class.java,"movies_app.sqlite")
            .createFromAsset("movies_app.sqlite").build()
        return vt.getMoviesDao()
    }
}