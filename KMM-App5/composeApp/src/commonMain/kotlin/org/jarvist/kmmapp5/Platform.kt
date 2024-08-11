package org.jarvist.kmmapp5

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform