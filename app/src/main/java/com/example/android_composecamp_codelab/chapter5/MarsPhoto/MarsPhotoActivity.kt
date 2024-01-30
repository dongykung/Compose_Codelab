package com.example.android_composecamp_codelab.chapter5.MarsPhoto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.android_composecamp_codelab.chapter5.MarsPhoto.ui.MarsPhotoApp
import com.example.android_composecamp_codelab.ui.theme.Android_ComposeCamp_CodelabTheme

class MarsPhotoActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Android_ComposeCamp_CodelabTheme {
                Surface(modifier=Modifier.fillMaxSize()) {
                    MarsPhotoApp()
                }
            }
        }
    }
}