package com.example.android_composecamp_codelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_composecamp_codelab.ui.theme.Android_ComposeCamp_CodelabTheme

class Composequadrant:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_ComposeCamp_CodelabTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

@Composable
private fun ComposeQuadrantApp(){
        Column(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.weight(1f)) {
                ComposableInfoCard(stringResource(id = R.string.sequadrant1),
                    stringResource(id = R.string.sequadrant2),
                    Modifier.weight(1f),
                    Color(0xFFEADDFF))

                ComposableInfoCard(stringResource(id = R.string.sequadrant3),
                    stringResource(id = R.string.sequadrant4),
                    Modifier.weight(1f),
                    Color(0xFFD0BCFF))
            }

            Row(modifier = Modifier.weight(1f)) {
                ComposableInfoCard(stringResource(id = R.string.sequadrant5),
                    stringResource(id = R.string.sequadrant6),
                    Modifier.weight(1f),
                    Color(0xFFB69DF8))
                ComposableInfoCard(stringResource(id = R.string.sequadrant7),
                    stringResource(id = R.string.sequadrant8),
                    Modifier.weight(1f),
                    Color(0xFFF6EDFF))
            }
        }
}

@Composable
private fun ComposableInfoCard(title:String,
                               description:String,
                               modifier:Modifier = Modifier,
                               color: Color
){
        Column(modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = title,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(text = description, textAlign = TextAlign.Justify)
            
        }
}


@Preview(showBackground = true)
@Composable
fun ComposeQuadrantAppPreview() {
    Android_ComposeCamp_CodelabTheme {
        ComposeQuadrantApp()
    }
}