package org.jarvist.kmmapp3

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform