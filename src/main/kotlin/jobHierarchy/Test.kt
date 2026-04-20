package org.example.jobHierarchy

import kotlinx.coroutines.*
import java.util.concurrent.Executors
import kotlin.time.Duration.Companion.milliseconds

private val dispatcherIO = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
private val parent = Job()
private val scope = CoroutineScope(dispatcherIO + parent)

fun main() {
    scope.launch {
        launch {
            coroutineContext.job.parent?.let { println(it) }
            printNumber(1)
        }
        launch {
            coroutineContext.job.parent?.let { println(it) }
            printNumber(2)
        }
    }
    Thread.sleep(1000)
    parent.cancel()
}

private suspend fun printNumber(number: Int) {
    while (true) {
        println(number)
        delay(1000.milliseconds)
    }
}