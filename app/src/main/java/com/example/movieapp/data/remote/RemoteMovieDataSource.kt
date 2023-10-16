package com.example.movieapp.data.remote

import com.example.movieapp.application.AppConstants
import com.example.movieapp.data.model.*
import com.example.movieapp.repository.IWebService

class RemoteMovieDataSource (private val webservice: IWebService ){

    suspend fun getTopRatedMovies(): MovieList = webservice.getTopRatedMovies(AppConstants.API_KEY)

    suspend fun getUpcomingMovies(): MovieList = webservice.getUpcomingMovies(AppConstants.API_KEY)

    suspend fun getPopularMovies(): MovieList = webservice.getPopularMovies(AppConstants.API_KEY)

}




