package com.example.mvp_with_realm.registration

interface RegisterView {
    val name: String

    val password: String

    fun showNameError(resId: Int)

    fun showPasswordError(resId: Int)

    fun startAuthActivity()

}
