package com.example.mvp_with_realm.auth

interface AuthView {
    val name: String

    val password: String

    fun showNameError(resId: Int)

    fun showPasswordError(resId: Int)

    fun startRegisterActivity()

    fun startMainActivity()

    fun startAddQuestionActivity()

    fun showLoginIncorrectError(resId: Int)
}
