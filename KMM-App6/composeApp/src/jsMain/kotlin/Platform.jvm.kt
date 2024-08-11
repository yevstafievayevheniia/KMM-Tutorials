package org.jarvist.kmmapp6

class JSPlatform: Platform {
    override val name: String = "Compose for Web"
}

actual fun getPlatform(): Platform = JSPlatform()