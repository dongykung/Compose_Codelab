package com.example.android_composecamp_codelab.chapter5.MarsPhoto.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.android_composecamp_codelab.R
import com.example.android_composecamp_codelab.chapter5.MarsPhoto.data.MarsPhoto

@Composable
fun HomeScreen(
    marsUiState: MarsUiState,
    modifier: Modifier = Modifier,
    contentpadding: PaddingValues = PaddingValues(0.dp),
    retryAction : () -> Unit
) {
    when(marsUiState){
        is MarsUiState.Loading ->{
            LoadingScreen(modifier=Modifier.fillMaxSize())
        }
        is MarsUiState.Error ->{
            ErrorScreen(retryAction = retryAction, modifier=Modifier.fillMaxSize())
        }
        is MarsUiState.Success ->{
            MarsPhotoGrid(photos = marsUiState.photos,modifier=Modifier.fillMaxWidth(), paddingValues = contentpadding)
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier=Modifier){
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading)
    )
}

@Composable
fun ErrorScreen(retryAction : () ->Unit,modifier: Modifier=Modifier){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
        Button(onClick = retryAction) {
            Text(stringResource(R.string.retry))
        }
    }
}




@Composable
fun MarsPhotoCard(photo: MarsPhoto, modifier: Modifier = Modifier) {
    Card(modifier=modifier.padding(4.dp),
        elevation = CardDefaults.cardElevation(8.dp)) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(photo.imgSrc)
                .crossfade(true)
                .build(),
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img),
            contentDescription = stringResource(R.string.mars_photo),
            contentScale = ContentScale.Crop,
        )
    }

}
@Composable
fun MarsPhotoGrid(photos:List<MarsPhoto>,modifier: Modifier=Modifier,paddingValues: PaddingValues){
    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 150.dp),
        modifier=modifier.fillMaxWidth(),
        contentPadding = paddingValues
    ){
        items(photos, key = {photo->photo.id}){photo->
            MarsPhotoCard(photo = photo,modifier=modifier.padding(4.dp)
                .fillMaxWidth()
                .aspectRatio(1.5f))
        }
    }
}