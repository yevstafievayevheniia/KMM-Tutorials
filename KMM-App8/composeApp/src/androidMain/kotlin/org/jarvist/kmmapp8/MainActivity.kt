package org.jarvist.kmmapp8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.FirebaseOptions
import dev.gitlive.firebase.initialize

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Firebase.initialize(
            applicationContext,
            options = FirebaseOptions(
                applicationId = "1:1028413608341:android:79a7f1c9a5a0b5158e269c",
                apiKey = "AIzaSyDcV0J7gyosFcYt3QoVepAaLx4dJBUPRt4",
                projectId = "bimooddevelopment"
            )
        )

        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}