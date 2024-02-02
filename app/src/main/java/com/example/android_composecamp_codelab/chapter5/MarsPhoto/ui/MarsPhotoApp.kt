package com.example.android_composecamp_codelab.chapter5.MarsPhoto.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.android_composecamp_codelab.R
import com.example.android_composecamp_codelab.chapter5.MarsPhoto.ui.screen.HomeScreen
import com.example.android_composecamp_codelab.chapter5.MarsPhoto.ui.screen.MarsViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarsPhotoApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MarsTopAppBar(scrollBehavior = scrollBehavior)
        }) {
        val marsViewModel:MarsViewModel= viewModel(factory = MarsViewModel.Factory)
        Surface(modifier = Modifier.fillMaxSize()) {
            HomeScreen(marsUiState = marsViewModel.marsUiState, contentpadding = it)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarsTopAppBar(
    scrollBehavior: TopAppBarScrollBehavior,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.mars_photo),
                style = MaterialTheme.typography.headlineSmall
            )
        },
        scrollBehavior = scrollBehavior,
        modifier=modifier
    )
}