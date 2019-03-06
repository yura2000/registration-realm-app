package com.example.mvp_with_realm.new_question

interface AddQuestionView {

    val question: String

    val answer1: String

    val answer2: String

    val answer3: String

    val answer4: String

    fun showQuestionError(resId: Int)

    fun showAnswer1Error(resId: Int)

    fun showAnswer2Error(resId: Int)

    fun showAnswer3Error(resId: Int)

    fun showAnswer4Error(resId: Int)

    fun showAddSuccess(resId: Int)

    fun startTestActivity()
}