package com.example.mvp_with_realm.realm_classes

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class Question(
    @PrimaryKey var id: Long = 0,
    @Required var text: String = "",
    @Required var answers: RealmList<Answer> = RealmList()
) : RealmObject() {

}