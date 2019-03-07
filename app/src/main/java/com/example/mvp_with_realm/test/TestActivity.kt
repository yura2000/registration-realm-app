package com.example.mvp_with_realm.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mvp_with_realm.R
import com.example.mvp_with_realm.new_question.Question
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_add_question.*
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    val realm = Realm.getDefaultInstance()

    val question =
        realm.where(Question::class.java).equalTo("id", 4.toLong())
            .findFirst()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        Realm.init(this)
        val config = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(config)

        question_tv?.setText(question!!.text)
        answer1_rb?.setText(answer1!!.text)
        answer2_rb?.setText(answer2!!.text)
    }

    val answer1 =
        realm.where(Question::class.java).equalTo("answers.id", 1.toLong())
            .findFirst()

    val answer2 =
        realm.where(Question::class.java).equalTo("answers.id", 2.toLong())
            .findFirst()

}
