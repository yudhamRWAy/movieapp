package com.yudha.techtest.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


    @Parcelize
    @Entity(tableName = "genre")
    data class Genre(
        @PrimaryKey(autoGenerate = false) var id: Int = 0,
        var name: String? = null
    ) : Parcelable

