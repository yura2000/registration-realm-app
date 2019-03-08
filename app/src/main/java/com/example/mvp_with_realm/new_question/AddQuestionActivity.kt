package com.example.mvp_with_realm.new_question

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.example.mvp_with_realm.R
import com.example.mvp_with_realm.new_question.fragments.AddQuestionFragment
import com.example.mvp_with_realm.new_question.fragments.AddTopicFragment
import com.example.mvp_with_realm.test.TestActivity
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_add_question.*
import kotlinx.android.synthetic.main.fragment_add_question.*

class AddQuestionActivity : AppCompatActivity(), AddQuestionView {

    private var presenter: AddQuestionPresenter? = null
    private val frag2:Fragment = AddTopicFragment()
    private val frag1:Fragment = AddQuestionFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_question)

        Realm.init(this)
        val config = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(config)

        presenter = AddQuestionPresenter(this, AddQuestionService())

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, frag1)
            .addToBackStack(null)
            .commit()
    }



    override val question: String
        get() = question_et.text.toString()
    override val answer1: String
        get() = answer1_et.text.toString()
    override val answer2: String
        get() = answer2_et.text.toString()
    override val answer3: String
        get() = answer3_et.text.toString()
    override val answer4: String
        get() = answer4_et.text.toString()

    fun onAddClicked(view: View) {
        presenter!!.onAddClicked()
    }

    fun onGoToQuestionClicked(view: View) {
        presenter!!.onGoToQuestionClicked()
    }

    fun onAddTopicClicked(view: View) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, frag2)
            .addToBackStack(null)
            .commit()
        TODO("Зробити кліклісенери")
    }

    override fun startTestActivity() {
        val intent = Intent(this, TestActivity::class.java)
        startActivity(intent)
    }

    override fun showQuestionError(resId: Int) {
        question_et.error = getString(resId)
    }

    override fun showAnswer1Error(resId: Int) {
        answer1_et.error = getString(resId)
    }

    override fun showAnswer2Error(resId: Int) {
        answer2_et.error = getString(resId)
    }

    override fun showAnswer3Error(resId: Int) {
        answer3_et.error = getString(resId)
    }

    override fun showAnswer4Error(resId: Int) {
        answer4_et.error = getString(resId)
    }

    override fun showAddSuccess(resId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
