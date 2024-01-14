package com.example.android_composecamp_codelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_composecamp_codelab.ui.theme.Android_ComposeCamp_CodelabTheme

class BusinessCard:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_ComposeCamp_CodelabTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

@Composable
private fun BusinessCardScreen(){
        Column(modifier = Modifier
            .background(Color(0xFFE4FFC5)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            MyInfo(painterResource(R.drawable.android_logo),
                stringResource(id = R.string.myname),stringResource(id = R.string.myinfo))
        }

    val numberIcon = Icons.Filled.Call
    val devIcon = Icons.Filled.Share
    val emailIcon = Icons.Filled.Email
    Column(modifier = Modifier
        .padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally) {
        MyContactInfo(stringResource(id = R.string.mynumber), stringResource(id = R.string.mydev),
            stringResource(id = R.string.myemail),numberIcon,devIcon,emailIcon)
    }
}
@Composable
private fun MyInfo(image:Painter,
                   name:String,
                   description:String){

           Image(painter = image, contentDescription = null,
               modifier = Modifier
                   .fillMaxWidth()
                   .height(120.dp)
                   .padding(8.dp))
            Text(text = name,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textAlign = TextAlign.Center)
        Text(text = description,
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF3ddc84),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textAlign = TextAlign.Center)

}
@Composable
private fun MyContactInfo(number: String, dev: String, email: String,
                          numberIcon: ImageVector, devIcon: ImageVector, emailIcon: ImageVector) {

    Row(
        modifier = Modifier
            .padding(8.dp)
        , verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(imageVector = numberIcon, contentDescription = null, modifier = Modifier.align(Alignment.CenterVertically))
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(
            text = number,
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Center
        )
    }
    Row(
        modifier = Modifier
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(imageVector = devIcon, contentDescription = null, modifier = Modifier.align(Alignment.CenterVertically))
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(
            text = dev,
            modifier = Modifier.padding(8.dp)
        )
    }
    Row(
        modifier = Modifier
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(imageVector = emailIcon, contentDescription = null, modifier = Modifier.align(Alignment.CenterVertically))
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(
            text = email,
            modifier = Modifier.padding(8.dp)
        )
    }
}





@Preview(showBackground = true)
@Composable
fun DefaultBusinessCardPreView(){
    Android_ComposeCamp_CodelabTheme {
        BusinessCardScreen()
    }
}