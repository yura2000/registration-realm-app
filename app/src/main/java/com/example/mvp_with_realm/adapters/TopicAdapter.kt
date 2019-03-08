package com.example.mvp_with_realm.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mvp_with_realm.R
import com.example.mvp_with_realm.realm_classes.Topic

class TopicAdapter(private val values: List<Topic>): RecyclerView.Adapter<TopicViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TopicViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.item_topic, p0, false)
        return TopicViewHolder(itemView)
    }

    override fun getItemCount() = values.size

    override fun onBindViewHolder(holder: TopicViewHolder, pos: Int) {
        val topic: Topic = values[pos]
        holder.bind(topic)
    }
}