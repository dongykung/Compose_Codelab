package com.example.android_composecamp_codelab.chapter5.MarsPhoto.data


import com.example.android_composecamp_codelab.chapter5.MarsPhoto.network.MarsApiService

interface MarsPhotosRepository {
    suspend fun getMarsPhotos():List<MarsPhoto>
}



class NetworkMarsPhotosRepository(private val marsApiService: MarsApiService) : MarsPhotosRepository{
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return marsApiService.getphotos()
    }
}