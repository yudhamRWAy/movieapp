package com.yudha.techtest.data.dao

import com.yudha.techtest.data.model.Movie
import androidx.room.Dao
import androidx.room.Query


@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    fun getMovieList(): List<Movie>?

    @Query("SELECT * FROM movie WHERE movie.id = :id")
    fun getMovieById(id: String): Movie?

    @Query("DELETE FROM movie WHERE id = :id")
    fun deleteMovieById(id: String)

    @Query("SELECT * FROM movie LIMIT :pageSize OFFSET :pageIndex")
    fun getMoviePage(pageSize: Int, pageIndex: Int): List<Movie>?

    @Query("SELECT * FROM movie WHERE movie.isFavorite = 1 LIMIT :pageSize OFFSET ((:pageIndex-1)*:pageSize) ")
    fun getFavorite(pageSize: Int, pageIndex: Int): List<Movie>?
}