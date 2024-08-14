package org.jarvist.kmmapp8.auth.viewModels

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.jarvist.kmmapp8.auth.models.LoginUiState
import org.jarvist.kmmapp8.base.BaseViewModel

class LoginViewModel(
    //TODO, add AuthService here
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    private val _emailError = MutableStateFlow(false)
    val emailError = _emailError.asStateFlow()

    private val _passwordError = MutableStateFlow(false)
    val passwordError = _passwordError.asStateFlow()

    fun onEmailChange(newValue: String) {
    }

    fun onPasswordChange(newValue: String) {
    }

    fun onSignInClick() {
    }

    fun onSignOut() {
        launchWithCatchingException {
        }
    }
}