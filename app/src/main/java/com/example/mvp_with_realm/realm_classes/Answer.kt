package com.example.mvp_with_realm.realm_classes

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class Answer (
    @PrimaryKey var id: Long = 0,
    @Required var text: String = ""
): RealmObject() {

}