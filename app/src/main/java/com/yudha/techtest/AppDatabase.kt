package com.yudha.techtest

import androidx.room.Database
import androidx.room.RoomDatabase

import com.yudha.techtest.data.dao.GenreDao
import com.yudha.techtest.data.dao.MovieDao
import com.yudha.techtest.data.model.Genre
import com.yudha.techtest.data.model.Movie

@Database(entities = [Movie::class, Genre::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getMovieDao(): MovieDao
    abstract fun getGenreDao(): GenreDao
}