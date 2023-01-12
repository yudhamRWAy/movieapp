package com.yudha.techtest.data.remote

import com.yudha.techtest.data.remote.response.GenreResponse
import retrofit2.http.GET


interface GenreApi {
    @GET("3/genre/movie/list")
    suspend fun getGenreList(): GenreResponse
}