package com.example.android_composecamp_codelab.Chapter3.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId : Int,
    val like : Int,
    @DrawableRes val imageResourceId:Int
)