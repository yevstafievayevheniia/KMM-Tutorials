package org.jarvist.kmmapp4

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform