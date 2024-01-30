package com.example.android_composecamp_codelab.chapter5.MarsPhoto.network

import com.example.android_composecamp_codelab.chapter5.MarsPhoto.data.MarsPhoto
import retrofit2.http.GET

interface MarsApiService {
    @GET
    suspend fun getphotos():List<MarsPhoto>
}