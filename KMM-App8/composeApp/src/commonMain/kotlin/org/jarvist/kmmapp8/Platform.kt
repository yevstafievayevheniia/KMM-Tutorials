package org.jarvist.kmmapp8

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform