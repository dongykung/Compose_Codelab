package com.example.android_composecamp_codelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_composecamp_codelab.ui.theme.Android_ComposeCamp_CodelabTheme

class ComposeTaskManager:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_ComposeCamp_CodelabTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    TaskManagerScreen()
                }
            }
        }
    }
}

@Composable
private fun TaskManagerScreen(){
   Column(modifier = Modifier.fillMaxSize(),
       horizontalAlignment = Alignment.CenterHorizontally,
       verticalArrangement = Arrangement.Center) {
            Image(painter = painterResource(R.drawable.ic_task_completed), contentDescription = null)
            Text(text = stringResource(R.string.taskmanager),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp))
            Text(text = stringResource(id = R.string.taskmanager2),
                fontSize = 16.sp)

   }
}



@Preview(showBackground = true)
@Composable
fun DefaultTaskManagerPreView(){
    Android_ComposeCamp_CodelabTheme {
        TaskManagerScreen()
    }
}