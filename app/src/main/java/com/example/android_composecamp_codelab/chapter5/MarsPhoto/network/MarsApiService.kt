package com.example.android_composecamp_codelab.chapter5.MarsPhoto.network

import com.example.android_composecamp_codelab.chapter5.MarsPhoto.data.MarsPhoto
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
interface MarsApiService {
    @GET("photos")
     suspend fun getphotos():List<MarsPhoto>
}


//private const val BASE_URL =  "https://android-kotlin-fun-mars-server.appspot.com"
//
//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
//    .baseUrl(BASE_URL)
//    .build()
//
//private val retrofit2 = Retrofit.Builder()
//    .addConverterFactory(GsonConverterFactory.create())
//    .baseUrl(BASE_URL)
//    .build()
//



