package com.example.android_composecamp_codelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class test : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
                ProduceStateExample()
            }
        }
    }
}

@Composable
fun LaunchedEffectExample() {
    var counter by remember { mutableStateOf(0) }

    Column {
        Text("Counter: $counter", modifier = Modifier.padding(16.dp))

        Button(onClick = {
            counter++
        }) {
            Text("Increment Counter")
        }

        // LaunchedEffect를 통한 부수 효과
        LaunchedEffect(counter) {
            // counter 값이 변경될 때 실행되는 부수 효과
            println("Counter changed to $counter")
            // 여기에 추가적인 비동기 동작 또는 상태 변경 등을 수행할 수 있음
        }
    }
}

@Composable
fun ProduceStateExample() {
    // produceState를 사용하여 Flow를 통한 상태 생성
    val counterFlow = produceState(initialValue = 0) {
        // Flow 내에서 상태 변경을 처리
        for (i in 1..5) {

            value = i
        }
    }

    // Compose UI에서 Flow의 값을 사용
    Column {
        Text("Counter: ${counterFlow.value}", modifier = Modifier.padding(16.dp))
    }
}


