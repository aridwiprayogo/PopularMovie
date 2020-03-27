package com.aridwiprayogo.popularmovie.data.local.movie

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val src: String,
    val overview: String,
    val releaseDate: String,
    val backdropPath: String,
    val voteCount: Int,
    val voteAverage: Double
)