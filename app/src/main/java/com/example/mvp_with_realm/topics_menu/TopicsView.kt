package com.example.mvp_with_realm.topics_menu

import com.example.mvp_with_realm.realm_classes.Topic

interface TopicsView {

    fun showTopics(topics: List<Topic>)

}