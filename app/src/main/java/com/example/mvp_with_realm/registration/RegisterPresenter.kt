package com.example.mvp_with_realm.registration

import com.example.mvp_with_realm.R
import io.realm.Realm

class RegisterPresenter(private val view: RegisterView, private val service: RegisterService) {

    fun onRegisterClicked() {
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
        val realm = Realm.getDefaultInstance()

        realm.executeTransaction { realm ->
            val dataObject = realm.createObject(Person::class.java, 2)
            dataObject!!.username = username
            dataObject!!.password = password
        }

        view.startAuthActivity()
        return
    }
}
