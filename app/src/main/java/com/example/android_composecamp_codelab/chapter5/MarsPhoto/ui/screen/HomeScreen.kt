package com.example.android_composecamp_codelab.chapter5.MarsPhoto.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    marsUiState: String,
    modifier: Modifier = Modifier,
    contentpadding: PaddingValues = PaddingValues(0.dp)
) {
    ResultScreen(photos = marsUiState,Modifier.padding(top = contentpadding.calculateTopPadding()))
}


@Composable
fun ResultScreen(photos: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier, contentAlignment = Alignment.Center
    ) {
        Text(text = photos)
    }
}