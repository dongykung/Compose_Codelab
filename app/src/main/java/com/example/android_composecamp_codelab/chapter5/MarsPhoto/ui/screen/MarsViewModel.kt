package com.example.android_composecamp_codelab.chapter5.MarsPhoto.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MarsViewModel:ViewModel() {

    var marsUiState:String by mutableStateOf("")
        private set

    init {
        getMarsPhotos()
    }

    fun getMarsPhotos(){
        marsUiState = "Set the Mars API status response here"
    }
}