package com.example.android_composecamp_codelab.chapter5.MarsPhoto.data

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarsPhoto(
    val id: String,
    @SerialName(value="img_src")
    val imgSrc: String
)
