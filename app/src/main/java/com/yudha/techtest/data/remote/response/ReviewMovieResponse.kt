package com.yudha.techtest.data.remote.response

import com.yudha.techtest.data.model.Review

data class ReviewMovieResponse (
    val id: Int? = null,
    val page: Int? = null,
    var results: List<Review>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)
