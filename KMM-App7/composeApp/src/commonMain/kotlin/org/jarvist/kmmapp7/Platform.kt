package org.jarvist.kmmapp7

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform