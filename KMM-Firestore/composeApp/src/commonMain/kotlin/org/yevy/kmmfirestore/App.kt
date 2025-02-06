package org.yevy.kmmfirestore

import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.yevy.kmmfirestore.data.FirestoreUserRepository
import org.yevy.kmmfirestore.presentation.UserScreen

@Composable
@Preview
fun App() {
    val userRepository = remember { FirestoreUserRepository() }
    UserScreen(userRepository)
}