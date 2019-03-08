package com.example.mvp_with_realm.adapters

import android.support.v7.widget.RecyclerView
import android.view.TextureView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.mvp_with_realm.R
import com.example.mvp_with_realm.realm_classes.Topic
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_topic.view.*

class TopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var topicName: TextView? = null
    var topicImgUrl: ImageView? = null
    var topicNumOfQuestions: TextView? = null

    init {
        topicName = itemView.findViewById(R.id.topicName_tv)
        topicImgUrl = itemView.findViewById(R.id.topicImage_img)
        topicNumOfQuestions = itemView.findViewById(R.id.topicNumOfQuestions_tv)
    }

    fun bind(topic: Topic) {
        topicName?.text = topic.name
        Picasso.get().load(topic.imgUrl).into(topicImgUrl)
        topicNumOfQuestions?.text = topic.numberOfQuestions.toString()
    }
}