package com.example.mvp_with_realm.auth

import io.realm.Realm

class AuthService {
    fun auth(username: String, password: String): Boolean {
        val realm = Realm.getDefaultInstance()

        val persons =
            realm.where(com.example.mvp_with_realm.registration.Person::class.java).equalTo("username", username)
                .findFirst()

        return persons!!.username == username && persons!!.password == password
    }
}
