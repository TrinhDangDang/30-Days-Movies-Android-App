package com.example.days.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Movie(
    @StringRes val movieNameRes: Int,
    @DrawableRes val movieImageRes: Int,
    @StringRes val movieDesRes: Int,
    val day: Int
)
