package com.example.coroutine

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        println("Weather forecast")
        println(getWeatherReport4())
        println("Have a good day!")
    }
}
/*
* cancel() -> 코루틴은 취소될 수 있지만, 동일한 범위의 다른 코루틴에 영향을 미치지 않으며 상위 코루틴은 취소 X
* */
suspend fun getWeatherReport4() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async { getTemperature() }

    delay(200)
    temperature.cancel() // Sunny만 출력되고 Have a good day! 출력

    forecast.await()
}
