package com.example.movieapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



data class Movie(
    val id: Int = -1,
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = -1.0,
    val poster_path: String = "",
    val relese_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = -1.0,
    val vote_count: Int = -1,
    val movie_type: String = ""
)

//Room

@Entity
data class MovieEntity(
    @PrimaryKey
    val id: Int = -1,
    @ColumnInfo(name = "adult")
    val adult: Boolean = false,
    @ColumnInfo(name = "backdrop_path")
    val backdrop_path: String = "",
    @ColumnInfo(name = "original_language")
    val original_language: String = "",
    @ColumnInfo(name = "original_title")
    val original_title: String = "",
    @ColumnInfo(name = "overview")
    val overview: String = "",
    @ColumnInfo(name = "popularity")
    val popularity: Double = -1.0,
    @ColumnInfo(name = "poster_path")
    val poster_path: String = "",
    @ColumnInfo(name = "relese_date")
    val relese_date: String = "",
    @ColumnInfo(name = "title")
    val title: String = "",
    @ColumnInfo(name = "video")
    val video: Boolean = false,
    @ColumnInfo(name = "vote_average")
    val vote_average: Double = -1.0,
    @ColumnInfo(name = "vote_count")
    val vote_count: Int = -1,
    @ColumnInfo(name = "movie_type")
    val movie_type: String = ""
)

data class MovieList(val results: List<Movie> = listOf())


fun List<MovieEntity>.toMovieList(): MovieList {
    val resultList = mutableListOf<Movie>()
    this.forEach { movieEntyti ->
        resultList.add(movieEntyti.toMovie())
    }
    return MovieList(resultList)
}


fun MovieEntity.toMovie(): Movie = Movie(
    this.id,
    this.adult,
    this.backdrop_path,
    this.original_language,
    this.original_title,
    this.overview,
    this.popularity,
    this.poster_path,
    this.relese_date,
    this.title,
    this.video,
    this.vote_average,
    this.vote_count,
    this.movie_type
)

fun Movie.toMovieEntity(movieType: String): MovieEntity = MovieEntity(
    this.id,
    this.adult,
    this.backdrop_path ?: "/tC78Pck2YCsUAtEdZwuHYUFYtOj.jpg",
    this.original_language,
    this.original_title,
    this.overview,
    this.popularity,
    this.poster_path,
    this.relese_date,
    this.title,
    this.video,
    this.vote_average,
    this.vote_count,
    movie_type = movieType
)


