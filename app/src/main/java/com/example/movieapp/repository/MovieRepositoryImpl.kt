package com.example.movieapp.repository

import com.example.movieapp.data.local.LocalMovieDataSource
import com.example.movieapp.data.model.MovieList
import com.example.movieapp.data.model.toMovieEntity
import com.example.movieapp.data.remote.RemoteMovieDataSource

class MovieRepositoryImpl(
    private val remotDataSource: RemoteMovieDataSource,
    private val dataSourceLocal: LocalMovieDataSource
) : MovieRepository {

    override suspend fun getUpcomingMovies(): MovieList {
        remotDataSource.getUpcomingMovies().results.forEach{movie ->
            dataSourceLocal.saveMovie(movie.toMovieEntity("upcoming"))
        }
        return dataSourceLocal.getUpcomingMovies()
    }

    override suspend fun getPopularMovies(): MovieList {
        remotDataSource.getPopularMovies().results.forEach{movie ->
            dataSourceLocal.saveMovie(movie.toMovieEntity("popular"))
        }
        return dataSourceLocal.getUpcomingMovies()
    }

    override suspend fun getTopRatedMovie(): MovieList {
        remotDataSource.getTopRatedMovies().results.forEach{movie ->
            dataSourceLocal.saveMovie(movie.toMovieEntity("topRated"))
        }
        return dataSourceLocal.getUpcomingMovies()
    }

}