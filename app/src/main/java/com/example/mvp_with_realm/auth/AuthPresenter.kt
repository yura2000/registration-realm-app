package com.example.mvp_with_realm.auth

import com.example.mvp_with_realm.R

class AuthPresenter(private val view: AuthView, private val service: AuthService) {

    fun onLoginClicked() {
        val username = view.name
        if (username.isEmpty()) {
            view.showNameError(R.string.username_error)
            return
        }
        val password = view.password
        if (password.isEmpty()) {
            view.showPasswordError(R.string.password_error)
            return
        }
        val loginSucceeded = service.auth(username, password)
        if (loginSucceeded) {
            view.startMainActivity()
            return
        }
        view.showLoginIncorrectError(R.string.auth_failed)
    }

    fun onRegisterInAuthClicked() {
        view.startRegisterActivity()
    }
}
