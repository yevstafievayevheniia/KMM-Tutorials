package org.jarvist.kmmapp4

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMM-App4",
    ) {
        App()
    }
}