package com.bignerdranch.android.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {

    var currentIndex = 0
    var isCheater = false

    private val questionBank = listOf(
        Question(R.string.question_noriaki, true),
        Question(R.string.question_audi, false),
        Question(R.string.question_kotlin, true),
        Question(R.string.question_deska, false),
        Question(R.string.question_btc, true)
    )

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun moveToPrev() {
        if (currentIndex > 0) {
            currentIndex = (currentIndex - 1) % questionBank.size
        } else {
            currentIndex = questionBank.size - 1
        }
    }

}

