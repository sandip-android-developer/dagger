package com.example.daggerdemo.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.daggerdemo.user.UserManager
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val userManager: UserManager) {

    private val _loginState = MutableLiveData<LoginActivity.LoginViewState>()
    val loginState: LiveData<LoginActivity.LoginViewState>
        get() = _loginState

    fun login(username: String, password: String) {
        if (userManager.loginUser(username, password)) {
            _loginState.value = LoginActivity.LoginSuccess
        } else {
            _loginState.value = LoginActivity.LoginError
        }
    }

    fun unregister() {
        userManager.unregister()
    }

    fun getUsername(): String = userManager.username
}