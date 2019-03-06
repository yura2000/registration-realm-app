package com.example.mvp_with_realm.registration

import com.example.mvp_with_realm.R
import io.realm.Realm
import io.realm.RealmConfiguration

class RegisterPresenter(private val view: RegisterView, private val service: RegisterService) {

    fun onRegisterClicked() {
        val username = view.name
        if (username.isEmpty()) {
            view.showNameError(com.example.mvp_with_realm.R.string.username_error)
            return
        }
        val password = view.password
        if (password.isEmpty()) {
            view.showPasswordError(com.example.mvp_with_realm.R.string.password_error)
            return
        }
        val realm = Realm.getDefaultInstance()

        val loginSucceeded = service.checkRegisteredPerson(username)
        if (!loginSucceeded) {
            realm.executeTransaction { realm ->
                val dataObject = realm.createObject(Person::class.java, 2)
                dataObject!!.username = username
                dataObject!!.password = password
            }

            view.startAuthActivity()
            return
        } else {
            view.showUserWithThisUsernameAlreadyExists(com.example.mvp_with_realm.R.string.usernameExists)
            return
        }
    }
}
