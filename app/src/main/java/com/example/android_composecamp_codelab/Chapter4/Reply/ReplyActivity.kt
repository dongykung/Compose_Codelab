package com.example.android_composecamp_codelab.Chapter4.Reply

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.android_composecamp_codelab.Chapter4.Reply.ui.ReplyApp
import com.example.android_composecamp_codelab.ui.theme.Android_ComposeCamp_CodelabTheme

class ReplyActivity:ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_ComposeCamp_CodelabTheme {
                val windowSize = calculateWindowSizeClass(activity = this)
                ReplyApp(windowSize=windowSize.widthSizeClass)
            }
        }
    }
}