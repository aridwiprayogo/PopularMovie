package com.aridwiprayogo.popularmovie.data.local.tv

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TvEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val release_date: String,
    val vote_count: Int,
    val vote_average: Double,
    val overview: String,
    val image: String
)