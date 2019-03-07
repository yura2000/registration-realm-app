package com.example.mvp_with_realm.realm_classes

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class Topic(
    @PrimaryKey var id: Long = 0,
    @Required var name: String = "",
    @Required var imgName: String = "",
    @Required var questions: RealmList<Question> = RealmList()
) : RealmObject() {

}