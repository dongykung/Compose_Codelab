package com.example.android_composecamp_codelab.chapter5

import kotlinx.coroutines.*

fun main(){
    runBlocking {
        println("Weather forecast")
        println(getWeatherReport())
        println("Have a good day!")
    }
}

//코루틴 스코프는 실행된 코루틴을 포함한 모든 작업이 완료된 후에야 반환된다.
//함수가 내부적으로 동시에 작업을 하고 있더라도 모든 작업 완료 전까지는 반환되지 않는다
//호출자에게는 함수가 동기작업처럼 보인다.
suspend fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async {
        try {
            getTemperature()
        }catch (e:AssertionError){
            println("Caught exception $e")
            "{ No temperature found }"
        }
    }

    "${forecast.await()} ${temperature.await()}"
}

suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

suspend fun getTemperature(): String {
   delay(500)
    throw AssertionError("Temperature is invalid")
    return "30\u00b0C"
}

