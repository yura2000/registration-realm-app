package com.example.mvp_with_realm.topics_menu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.mvp_with_realm.R
import com.example.mvp_with_realm.adapters.TopicAdapter
import com.example.mvp_with_realm.realm_classes.Topic
import kotlinx.android.synthetic.main.activity_topics.*

class TopicsActivity : AppCompatActivity(), TopicsView {

    private var presenter: TopicsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topics)

        presenter = TopicsPresenter(this, TopicsService())

        presenter?.getTopics()
    }

    override fun showTopics(topics: List<Topic>) {

        val recyclerViewPhotos = topics_recycler_view
        recyclerViewPhotos?.layoutManager = LinearLayoutManager(this)
        recyclerViewPhotos?.adapter = TopicAdapter(topics)

    }
}
