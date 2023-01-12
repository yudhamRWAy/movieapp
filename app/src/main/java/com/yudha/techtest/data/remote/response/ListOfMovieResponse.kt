package com.yudha.techtest.data.remote.response

import com.yudha.techtest.data.model.Movie

data class ListOfMovieResponse (
    val page: Int? = null,
    val totalResults: Int? = null,
    val totalPages: Int? = null,
    var results: ArrayList<Movie>? = null
)