package com.example.android_composecamp_codelab.chapter5.Race_Tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.android_composecamp_codelab.chapter5.Race_Tracker.ui.RaceTrackerApp
import com.example.android_composecamp_codelab.ui.theme.Android_ComposeCamp_CodelabTheme

class RaceTrackerActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Android_ComposeCamp_CodelabTheme {
                Surface(modifier=Modifier.fillMaxSize()) {
                    RaceTrackerApp()
                }
            }
        }
    }
}