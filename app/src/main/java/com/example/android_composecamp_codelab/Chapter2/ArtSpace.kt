package com.example.android_composecamp_codelab.Chapter2

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_composecamp_codelab.R
import com.example.android_composecamp_codelab.ui.theme.Android_ComposeCamp_CodelabTheme

class ArtSpace : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_ComposeCamp_CodelabTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
private fun ArtSpaceScreen() {
    var imageNumber by remember { mutableStateOf(0) }
    var title by remember { mutableStateOf("") }
    var artist by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    var previous by remember { mutableStateOf(false) }
    var next by remember { mutableStateOf(true) }
    val imagePainter = when (imageNumber) {
        0 -> {
            title = stringResource(id = R.string.a1title)
            artist = stringResource(id = R.string.a1by)
            year = stringResource(id = R.string.a1year)
            previous=false
            R.drawable.a1
        }

        1 -> {
            title = stringResource(id = R.string.a2title)
            artist = stringResource(id = R.string.a2by)
            year = stringResource(id = R.string.a2year)
            previous=true
            next=true
            R.drawable.a2
        }

        2 -> {
            title = stringResource(id = R.string.a3title)
            artist = stringResource(id = R.string.a3by)
            year = stringResource(id = R.string.a3year)
            previous=true
            next=true
            R.drawable.a3
        }

        3 -> {
            title = stringResource(id = R.string.a4title)
            artist = stringResource(id = R.string.a4by)
            year = stringResource(id = R.string.a4year)
            previous=true
            next=true
            R.drawable.a4
        }

        else -> {
            title = stringResource(id = R.string.a5title)
            artist = stringResource(id = R.string.a5by)
            year = stringResource(id = R.string.a5year)
            next=false
            R.drawable.a5
        }
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        ImageLoad(
            painter = imagePainter,
            description = title,
            Modifier
                .padding(start = 24.dp, end = 24.dp, top = 18.dp, bottom = 10.dp)
                .wrapContentHeight(Alignment.CenterVertically)
                .weight(0.4f)
        )
        ImageInfo(
            title = title, author = artist, year = year,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(Alignment.CenterVertically)
                .padding(start = 24.dp, end = 24.dp, bottom = 20.dp, top = 40.dp)
        )

        Row(
            Modifier
                .padding(start = 24.dp, end = 24.dp, bottom = 15.dp)
                .fillMaxWidth()
                .weight(0.1f)
                .wrapContentHeight(Alignment.Bottom),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ImageButton(
                text = "Previous",
                onClick = {
                    imageNumber--
                },
                check = previous)
            ImageButton(
                text = "Nexet",
                onClick = {
                    imageNumber++
                },check = next)
        }

    }

}

@Composable
private fun ImageLoad(
    @DrawableRes painter: Int,
    description: String,
    modifier: Modifier = Modifier
) {
    Surface(
        shadowElevation = 20.dp,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = painter), contentDescription = description,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 18.dp, bottom = 18.dp),
            contentScale = ContentScale.Crop
        )
    }

}

@Composable
private fun ImageInfo(
    title: String,
    author: String,
    year: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            maxLines = 1,
            style = MaterialTheme.typography.titleLarge,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = author,
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "(${year})",
                color = Color.DarkGray
            )
        }
    }
}

@Composable
private fun ImageButton(
    text: String, onClick: () -> Unit,
    check:Boolean,
    modifier: Modifier = Modifier
) {
    Button(modifier = modifier, onClick = { onClick() }, enabled = check) {
        Text(text = text)
    }
}


@Preview
@Composable
private fun DefaultPreview() {
    Android_ComposeCamp_CodelabTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            ArtSpaceScreen()
        }
    }
}