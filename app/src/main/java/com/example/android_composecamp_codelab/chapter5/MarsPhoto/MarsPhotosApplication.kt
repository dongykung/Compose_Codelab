package com.example.android_composecamp_codelab.chapter5.MarsPhoto

import android.app.Application
import com.example.android_composecamp_codelab.chapter5.MarsPhoto.data.AppContainer
import com.example.android_composecamp_codelab.chapter5.MarsPhoto.data.DefaultAppContainer

class MarsPhotosApplication:Application() {
    lateinit var container : AppContainer
    override fun onCreate() {
        super.onCreate()
        container=DefaultAppContainer()
    }
}