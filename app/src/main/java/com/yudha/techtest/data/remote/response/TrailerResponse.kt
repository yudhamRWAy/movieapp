package com.yudha.techtest.data.remote.response

import com.yudha.techtest.BuildConfig



import com.yudha.techtest.data.model.Trailer

data class TrailerResponse(
    val id: Int? = null,
    val results: List<Trailer>? = null
)