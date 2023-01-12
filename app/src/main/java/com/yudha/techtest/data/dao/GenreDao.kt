package com.yudha.techtest.data.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yudha.techtest.data.model.Genre

@Dao
interface GenreDao {
    @Query("SELECT * FROM genre ORDER BY name ASC")
    fun getGenreList(): List<Genre>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Genre>)

}