package org.example.async

import kotlinx.coroutines.*
import java.util.concurrent.Executors

private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
    println("Exception caught")
}
private val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
private val scope = CoroutineScope(dispatcher + CoroutineName("My coroutine") + Job() + exceptionHandler)

fun main() {
    val defered = scope.async {
        method()
    }
    scope.launch  {
        defered.await()
    }
    scope.launch {
        method2()
    }
}

suspend fun method(): String {
    delay(3000)
    error("")
}

suspend fun method2() {
    delay(5000)
    println("Method2 is finished")
}