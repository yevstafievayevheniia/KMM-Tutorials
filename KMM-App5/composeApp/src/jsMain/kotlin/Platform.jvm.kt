package org.jarvist.kmmapp5

class JSPlatform: Platform {
    override val name: String = "Compose for Web"
}

actual fun getPlatform(): Platform = JSPlatform()