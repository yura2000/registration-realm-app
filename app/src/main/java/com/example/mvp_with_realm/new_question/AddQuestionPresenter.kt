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
        val answer1_obj: Answer =
            Answer(1, answer1)
        val answer2_obj: Answer =
            Answer(2, answer2)
        val answer3_obj: Answer =
            Answer(3, answer3)
        val answer4_obj: Answer =
            Answer(4, answer4)

        realm.executeTransaction { realm ->
            val dataObject = realm.createObject(Question::class.java, 4)
            dataObject.text = question
            dataObject.answers.add(answer1_obj)
            dataObject.answers.add(answer2_obj)
            dataObject.answers.add(answer3_obj)
            dataObject.answers.add(answer4_obj)
        }

    }

    fun onGoToQuestionClicked() {
        view.startTestActivity()
    }
}