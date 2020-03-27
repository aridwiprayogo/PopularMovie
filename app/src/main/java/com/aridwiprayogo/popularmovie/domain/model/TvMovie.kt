package com.aridwiprayogo.popularmovie.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvMovie(
    val id: Int,
    val title: String,
    val release_date: String,
    val vote_count: Int,
    val vote_average: Double,
    val overview: String,
    val image: String
): Parcelable