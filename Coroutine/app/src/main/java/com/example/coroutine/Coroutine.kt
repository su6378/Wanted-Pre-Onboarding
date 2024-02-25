package com.example.coroutine

import kotlinx.coroutines.*

/*
* CoroutineContext는 코루틴이 실행될 컨텍스트에 관한 정보를 제공
* 이름 - 코루틴을 고유하게 식별하는 이름
* 작업 - 코루틴의 수명 주기를 제어함
* 디스패처 - 작업을 적절한 스레드에 전달함
* 예외 핸들러 - 코루틴에서 실행되는 코드에서 발생하는 예외를 처리함
*
* Dispatchers.Main - 이 디스패처를 사용하여 기본 Android 스레드에서 코루틴을 실행합니다.
* 이 디스패처는 주로 UI 업데이트 및 상호작용을 처리하고 빠른 작업을 실행하는 데 사용됩니다.
*
* Dispatchers.IO - 이 디스패처는 기본 스레드 외부에서 디스크 또는 네트워크 I/O를 실행하도록 최적화되어 있습니다.
* 예를 들어 파일에서 읽거나 파일에 쓰고 네트워크 작업을 실행합니다.
*
* Dispatchers.Default - 컨텍스트에 디스패처가 지정되지 않은 상태에서 launch() 및 async()를 호출할 때 사용되는 기본 디스패처입니다.
* 이 디스패처를 사용하여 계산이 많은 작업을 기본 스레드 외부에서 실행할 수 있습니다. 예를 들어 비트맵 이미지 파일을 처리합니다.
* */

fun main() {
    runBlocking {
        println("${Thread.currentThread().name} - runBlocking function")
        launch {
            println("${Thread.currentThread().name} - launch function")
            withContext(Dispatchers.Default) {
                println("${Thread.currentThread().name} - withContext function")
                delay(1000)
                println("10 results found.")
            }
            println("${Thread.currentThread().name} - end of launch function")
        }
        println("Loading...")
    }
}