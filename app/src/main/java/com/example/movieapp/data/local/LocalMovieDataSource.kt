package com.example.movieapp.data.local

import com.example.movieapp.application.AppConstants
import com.example.movieapp.data.model.MovieEntity
import com.example.movieapp.data.model.MovieList
import com.example.movieapp.data.model.toMovieList

class LocalMovieDataSource(private val movieDao: MovieDao) {

    suspend fun getTopRatedMovies(): MovieList {
        return movieDao.getAllMovie().filter{ it.movie_type == "topRated"}.toMovieList()
    }

    suspend fun getUpcomingMovies(): MovieList {
        return movieDao.getAllMovie().filter{ it.movie_type == "upcoming"}.toMovieList()
    }

    suspend fun getPopularMovies(): MovieList {
        return movieDao.getAllMovie().filter{ it.movie_type == "popular"}.toMovieList()
    }

    suspend fun saveMovie(movie: MovieEntity){
        movieDao.saveMovie(movie)
    }

}