package org.jarvist.kmmapp6

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform