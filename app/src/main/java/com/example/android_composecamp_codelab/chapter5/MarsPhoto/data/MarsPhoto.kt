package com.example.android_composecamp_codelab.chapter5.MarsPhoto.data

import com.google.gson.annotations.SerializedName

data class MarsPhoto(
    val id: String,
    @SerializedName(value = "img_src")
    val imgSrc: String
)
