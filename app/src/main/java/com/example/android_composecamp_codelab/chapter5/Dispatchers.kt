package com.example.android_composecamp_codelab.chapter5

import kotlinx.coroutines.launch
import kotlinx.coroutines.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch {
            withContext(Dispatchers.Default) {
                delay(1000)
                println("10 results found.")
            }
            println("110 results found.")
        }
        println("Loading...")
    }
}