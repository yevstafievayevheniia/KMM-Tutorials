package org.jarvist.kmmapp4

class JSPlatform: Platform {
    override val name: String = "Compose for Web"
}

actual fun getPlatform(): Platform = JSPlatform()