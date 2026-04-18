package org.example.executors

import java.util.concurrent.Executors

fun main() {
    val executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
    repeat(10_000) {
        executor.execute {
            proessImage(Image(it))
        }
    }
}

private fun proessImage(image: Image) {
    println("Image $image is processing")
    Thread.sleep(1000)
    println("Image $image processed")
}

data class Image(val id: Int)