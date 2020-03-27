package com.aridwiprayogo.popularmovie.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PopularMovie(
    val id: Int,
    val title: String,
    val src: String,
    val overview: String,
    val releaseDate: String,
    val backdropPath: String,
    val voteCount: Int,
    val voteAverage: Double
):Parcelable