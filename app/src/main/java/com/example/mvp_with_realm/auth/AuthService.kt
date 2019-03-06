package com.example.mvp_with_realm.auth

import com.example.mvp_with_realm.registration.MyMigration
import io.realm.Realm
import io.realm.RealmConfiguration

class AuthService {
    fun auth(username: String, password: String): Boolean {

        val config: RealmConfiguration = RealmConfiguration.Builder()
            .schemaVersion(2) // Must be bumped when the schema changes
            .migration(MyMigration()) // Migration to run instead of throwing an exception
            .build()

//        val config = RealmConfiguration.Builder()
//            .deleteRealmIfMigrationNeeded()
//            .build()
//        Realm.setDefaultConfiguration(config)

        val realm = Realm.getDefaultInstance()

        realm.beginTransaction()
        val persons =
            realm.where(com.example.mvp_with_realm.registration.Person::class.java).equalTo("username", username)
                .findFirst()
        realm.commitTransaction()

        return persons!!.username == username && persons!!.password == password
    }
}
