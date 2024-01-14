package com.example.android_composecamp_codelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_composecamp_codelab.ui.theme.Android_ComposeCamp_CodelabTheme

class ComposeArticle:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_ComposeCamp_CodelabTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ComposeArticleApp()
                }
            }
        }
    }
}

@Composable
private fun ComposeArticleApp(){
    ArticleCard(
        title = stringResource(R.string.title_jetpack_artical),
        shortDescription = stringResource(R.string.composedefine),
        longDescription = stringResource(R.string.composeinfo),
        imagePainter = painterResource(R.drawable.bg_compose_background)
    )
}

@Composable
private fun ArticleCard(title:String,
                        shortDescription : String,
                        longDescription : String,
                        imagePainter : Painter,
                        modifier: Modifier = Modifier)
{
    Column() {
        Image(painter = imagePainter, contentDescription = null)
        Text(text = title,
            fontSize = 24.sp,
            modifier=Modifier.padding(16.dp))
        Text(text = shortDescription,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier=Modifier.padding(start = 16.dp, end = 16.dp))
        Text(text = longDescription,
            fontSize = 16.sp,
            modifier=Modifier.padding(16.dp),
            textAlign = TextAlign.Justify)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultArticleCardPreView(){
    Android_ComposeCamp_CodelabTheme {
        ComposeArticleApp()
    }
}