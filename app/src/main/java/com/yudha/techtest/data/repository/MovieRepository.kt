package com.yudha.techtest.data.repository

import com.yudha.techtest.data.dao.MovieDao
import com.yudha.techtest.data.model.Movie
import com.yudha.techtest.data.remote.MovieApi
import com.yudha.techtest.data.remote.response.DetailMovieResponse
import com.yudha.techtest.data.remote.response.ListOfMovieResponse
import com.yudha.techtest.data.remote.response.ReviewMovieResponse
import com.yudha.techtest.data.remote.response.TrailerResponse


interface MovieRepository {
    suspend fun fetchMovieList(hashMap: HashMap<String, String>): ListOfMovieResponse
    suspend fun getMovieDetail(movieId: Int): DetailMovieResponse
    suspend fun getMovieReviews(page: String, movieId: Int): ReviewMovieResponse
    suspend fun getMovieById(id: String): Movie?
    suspend fun getMovieList(): List<Movie>?
    suspend fun getTrailerDetail(movieId: Int): TrailerResponse?
}

class MovieRepositoryImpl(
    private var apiService: MovieApi,
    private var movieDao: MovieDao
) : MovieRepository {
    override suspend fun fetchMovieList(hashMap: HashMap<String, String>): ListOfMovieResponse {
        return apiService.getDiscoverMovieAsync(hashMap)
    }

    override suspend fun getMovieDetail(movieId: Int): DetailMovieResponse {
        return apiService.getMovieDetail(movieId)
    }

    override suspend fun getMovieReviews(page: String, movieId: Int): ReviewMovieResponse {
        return apiService.getReviewList(movieId, page)
    }

    override suspend fun getTrailerDetail(movieId: Int): TrailerResponse? {
        return apiService.getTrailerDetail(movieId)
    }

    override suspend fun getMovieById(id: String): Movie? {
        return movieDao.getMovieById(id)
    }

    override suspend fun getMovieList(): List<Movie>? {
        return movieDao.getMovieList()
    }
}