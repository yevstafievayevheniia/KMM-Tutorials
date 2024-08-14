package org.jarvist.kmmapp8

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMM-App8",
    ) {
        App()
    }
}