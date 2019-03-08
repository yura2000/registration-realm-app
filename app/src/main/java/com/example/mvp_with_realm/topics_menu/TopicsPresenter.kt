package com.example.mvp_with_realm.topics_menu

import com.example.mvp_with_realm.realm_classes.Topic
import io.realm.Realm

class TopicsPresenter(private val view: TopicsView, private val service: TopicsService) {
    fun getTopics() {
        val realm = Realm.getDefaultInstance()

        realm.beginTransaction()
        val topics =
            realm.where(Topic::class.java).findAll()

        view.showTopics(topics)
        realm.commitTransaction()
    }
}