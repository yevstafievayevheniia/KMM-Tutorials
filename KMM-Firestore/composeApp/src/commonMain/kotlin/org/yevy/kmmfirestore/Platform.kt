package org.yevy.kmmfirestore

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform