package com.yudha.techtest.data.remote

import com.yudha.techtest.constant.ApiParams
import com.yudha.techtest.data.remote.response.DetailMovieResponse
import com.yudha.techtest.data.remote.response.ListOfMovieResponse
import com.yudha.techtest.data.remote.response.ReviewMovieResponse
import com.yudha.techtest.data.remote.response.TrailerResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface MovieApi {
    @GET("3/discover/movie")
    suspend fun getDiscoverMovieAsync(
        @QueryMap hashMap: HashMap<String, String> = HashMap()
    ): ListOfMovieResponse

    @GET("3/movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movie_id: Int
    ): DetailMovieResponse

    @GET("3/movie/{movie_id}/reviews")
    suspend fun getReviewList(
        @Path("movie_id") movie_id: Int,
        @Query(ApiParams.PAGE) page: String
    ): ReviewMovieResponse

    @GET("3/movie/{movie_id}/videos")
    suspend fun getTrailerDetail(
        @Path("movie_id") movie_id: Int
    ): TrailerResponse
}