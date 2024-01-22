package com.example.android_composecamp_codelab.Chapter4.Model

import androidx.annotation.DrawableRes

data class DessertData(
    @DrawableRes val imageId: Int, val price: Int, val startProductionAmount: Int
)
