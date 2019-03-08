package com.example.mvp_with_realm.new_question

import com.example.mvp_with_realm.R
import com.example.mvp_with_realm.realm_classes.Answer
import com.example.mvp_with_realm.realm_classes.Question
import io.realm.Realm

class AddQuestionPresenter(private val view: AddQuestionView, private val service: AddQuestionService) {

    fun onAddClicked() {
        val question = view.question
        if (question.isEmpty()) {
            view.showQuestionError(R.string.enter_data)
            return
        }

        val answer1 = view.answer1
        if (answer1.isEmpty()) {
            view.showAnswer1Error(R.string.enter_data)
            return
        }

        val answer2 = view.answer1
        if (answer2.isEmpty()) {
            view.showAnswer2Error(R.string.enter_data)
            return
        }

        val answer3 = view.answer1
        if (answer3.isEmpty()) {
            view.showAnswer3Error(R.string.enter_data)
            return
        }

        val answer4 = view.answer1
        if (answer4.isEmpty()) {
            view.showAnswer4Error(R.string.enter_data)
            return
        }

        val realm = Realm.getDefaultInstance()
        val answer1Obj =
            Answer(1, answer1)
        val answer2Obj =
            Answer(2, answer2)
        val answer3Obj =
            Answer(3, answer3)
        val answer4Obj =
            Answer(4, answer4)

        realm.executeTransaction { realm ->
            val dataObject = realm.createObject(Question::class.java, 4)
            dataObject.text = question
            dataObject.answers.add(answer1Obj)
            dataObject.answers.add(answer2Obj)
            dataObject.answers.add(answer3Obj)
            dataObject.answers.add(answer4Obj)
        }

    }

    fun onGoToQuestionClicked() {
        view.startTestActivity()
    }
}