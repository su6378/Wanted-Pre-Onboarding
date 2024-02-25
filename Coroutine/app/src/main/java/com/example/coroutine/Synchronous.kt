package com.example.coroutine

import kotlinx.coroutines.*
import kotlin.system.*

/*
* println()은 동기 호출
* main() 함수는 동기식
* delay()는 Kotlin 코루틴 라이브러리에서 제공되는 특수 정지 함수
* runBlocking()은 동기식이고 함수의 모든 작업이 완료되면 함수가 반환되어 프로그램이 종료
* */

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            printForecast()
            printTemperature()
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}
suspend fun printForecast() {
    delay(1000)
    println("Sunny")
}

suspend fun printTemperature() {
    delay(1000)
    println("30\u00b0C")
}