package com.example.quizapp.utils

import com.example.quizapp.R
import com.example.quizapp.model.Question

object Constants {

    const val USER_NAME = "user_name"
    const val TOTAL_QUESTIONS = "total_questions"
    const val CORRECT_ANSWERS = "correct_answers"

    fun getQuestions(): MutableList<Question> {
        val questions = mutableListOf<Question>()
        val questionOne = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.argentina_flag,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1
        )
        questions.add(questionOne)

        val questionTwo = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.brazil_flag,
            "Bolivia",
            "Brazil",
            "Bahamas",
            "Belgium",
            2
        )
        questions.add(questionTwo)

        val questionThree = Question(
            3,
            "What country does this flag belong to?",R.drawable.finland_flag,
            "Fiji",
            "Finland",
            "France",
            "French Guiana",
            2
        )
        questions.add(questionThree)

        val questionFour = Question(
            4,
            "What country does this flag belong to?",R.drawable.france_flag,
            "Falkland Islands",
            "Finland",
            "France",
            "Faroe Islands",
            3
        )
        questions.add(questionFour)

        val questionFive = Question(
            5,
            "What country does this flag belong to?",R.drawable.germany_flag,
            "Germany",
            "Georgia",
            "Ghana",
            "Greece",
            1
        )
        questions.add(questionFive)

        val questionSix = Question(
            6,
            "What country does this flag belong to?",R.drawable.haiti_flag,
            "Haiti",
            "Honduras",
            "Hungary",
            "Hong Kong",
            1
        )
        questions.add(questionSix)

        val questionSeven = Question(
            7,
            "What country does this flag belong to?",R.drawable.india_flag,
            "Iraq",
            "Indonesia",
            "Iran",
            "India",
            4
        )
        questions.add(questionSeven)

        val questionEight = Question(
            8,
            "What country does this flag belong to?",R.drawable.italy_flag,
            "Italy",
            "Iceland",
            "Ireland",
            "Israel",
            1
        )
        questions.add(questionEight)

        val questionNine = Question(
            9,
            "What country does this flag belong to?",R.drawable.nigeria_flag,
            "Nicaragua",
            "Niger",
            "Nigeria",
            "Norway",
            3
        )
        questions.add(questionNine)

        val questionTen = Question(
            10,
            "What country does this flag belong to?",R.drawable.spain_flag,
            "Senegal",
            "Serbia",
            "Sierra Leone",
            "Spain",
            4
        )
        questions.add(questionTen)
        return questions
    }
}