package org.jarvist.kmmapp3

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMM-App3",
    ) {
        App()
    }
}