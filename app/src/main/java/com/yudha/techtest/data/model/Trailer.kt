package com.yudha.techtest.data.model

import com.yudha.techtest.BuildConfig

data class Trailer(
    var id: String? = null,
    var key: String? = null,
    var site: String? = null,
    var size: Int? = null,
    var type: String? = null
)
{
    fun getYoutubeURL() =
        if (site == "YouTube") BuildConfig.YOUTUBE_URL + key else null
}