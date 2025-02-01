package org.yevy.kmmtodoapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform