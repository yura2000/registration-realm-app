package com.example.mvp_with_realm.auth

import com.example.mvp_with_realm.registration.MyMigration
import io.realm.Realm
import io.realm.RealmConfiguration

class AuthService {
    fun auth(username: String, password: String): Boolean {

        val config: RealmConfiguration = RealmConfiguration.Builder()
            .schemaVersion(2)
            .migration(MyMigration())
            .build()

        val realm = Realm.getDefaultInstance()

        realm.beginTransaction()
        val persons =
            realm.where(com.example.mvp_with_realm.registration.Person::class.java).equalTo("username", username)
                .findFirst()
        realm.commitTransaction()

        return persons!!.username == username && persons!!.password == password
    }
}
