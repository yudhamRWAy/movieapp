package com.yudha.techtest.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yudha.techtest.BuildConfig
import kotlinx.android.parcel.Parcelize
@Parcelize
@Entity(tableName = "movie")



    data class Movie(
        @PrimaryKey(autoGenerate = false)
        var id: Int = 0,
        var adult: Boolean? = false,
        var backdrop_path: String? = null,
        var budget: Int? = null,
        var homepage: String? = null,
        var imdb_id: String? = null,
        var original_language: String? = null,
        var original_title: String? = null,
        var overview: String? = null,
        var popularity: Double? = null,
        var poster_path: String? = null,
        var release_date: String? = null,
        var revenue: Int? = null,
        var runtime: Int? = null,
        var status: String? = null,
        var tagline: String? = null,
        var title: String? = null,
        var video: Boolean? = false,
        var vote_average: Double? = null,
        var vote_count: Int? = null,
        var isFavorite: Boolean? = false
    ) : Parcelable {

        fun getFullPosterPath() =
            if (poster_path.isNullOrBlank()) null else BuildConfig.IMAGE_URL + poster_path
}