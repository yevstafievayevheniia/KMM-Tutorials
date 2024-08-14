package org.jarvist.kmmapp8

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import org.jarvist.kmmapp8.auth.services.AuthServiceImpl
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jarvist.kmmapp8.auth.viewModels.LoginViewModel
import org.jarvist.kmmapp8.auth.views.LoginScreen

@Composable
@Preview
fun App() {
    MaterialTheme {

        //TODO, pass AuthService and LoginViewModel from here
        val loginViewModel = LoginViewModel(AuthServiceImpl(auth = Firebase.auth))

        Scaffold(
            modifier = Modifier.fillMaxWidth(),
        ) {
            LoginScreen(onLoginSuccess = {}, viewModel = loginViewModel)
        }
    }
}