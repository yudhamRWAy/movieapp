package com.yudha.techtest.data.repository


import com.yudha.techtest.data.dao.GenreDao
import com.yudha.techtest.data.model.Genre
import com.yudha.techtest.data.remote.GenreApi
import com.yudha.techtest.data.remote.response.GenreResponse


interface GenreRepository {
    suspend fun fetchGenreList(): GenreResponse
    suspend fun saveGenreToDb(data: List<Genre>)
    suspend fun getGenreList(): List<Genre>?
}

class GenreRepositoryImpl(
    private val apiService: GenreApi,
    private val genreDao: GenreDao
) : GenreRepository {
    override suspend fun fetchGenreList(): GenreResponse {
        return apiService.getGenreList()
    }

    override suspend fun saveGenreToDb(data: List<Genre>) {
        genreDao.insertAll(data)
    }

    override suspend fun getGenreList(): List<Genre>? {
        return genreDao.getGenreList()
    }
}