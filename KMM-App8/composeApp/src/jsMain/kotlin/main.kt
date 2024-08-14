package org.jarvist.kmmapp7

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.FirebaseOptions
import dev.gitlive.firebase.initialize
import org.jarvist.kmmapp8.App
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    Firebase.initialize(
        options = FirebaseOptions(
            applicationId = "1:1028413608341:web:a4611a6e5146eade8e269c",
            apiKey = "AIzaSyDcV0J7gyosFcYt3QoVepAaLx4dJBUPRt4",
            projectId = "bimooddevelopment"
        )
    )
    onWasmReady {
        CanvasBasedWindow(canvasElementId = "ComposeTarget") {
            App()
        }
    }
}