package com.example.android_composecamp_codelab.Chapter3.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val stringResourceId:Int,
    @DrawableRes val imageResourceId:Int
)

