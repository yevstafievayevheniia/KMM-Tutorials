package org.jarvist.kmmapp2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform