package com.example.mvp_with_realm.registration

import io.realm.Realm

class RegisterService {
    fun checkRegisteredPerson(username: String): Boolean {
        val realm = Realm.getDefaultInstance()

        val persons =
            realm.where(com.example.mvp_with_realm.registration.Person::class.java).equalTo("username", username)
                .findFirst()

        return persons?.username == username
    }
}
