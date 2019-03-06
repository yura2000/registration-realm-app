package com.example.mvp_with_realm.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mvp_with_realm.R
import com.example.mvp_with_realm.new_question.Question
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_add_question.*

class TestActivity : AppCompatActivity() {

    val realm = Realm.getDefaultInstance()

    val question =
        realm.where(Question::class.java).equalTo("id", "4")
            .findFirst()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        Realm.init(this)
        val config = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(config)

        question_et.setText(question?.text.toString())
    }

    val answer1 =
        realm.where(Question::class.java).equalTo("answers.id", "1")
            .findFirst()

}
