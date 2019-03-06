package com.example.mvp_with_realm.registration

import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class Person(
    @PrimaryKey var id: Long = 0,
    @Required var username: String = "",
    @Required var password: String = ""
) : RealmObject() {

}
