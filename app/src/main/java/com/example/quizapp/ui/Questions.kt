package com.example.quizapp.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quizapp.R
import com.example.quizapp.model.Question
import com.example.quizapp.utils.Constants

class Questions : AppCompatActivity(), View.OnClickListener {
    private lateinit var progressBar: ProgressBar
    private lateinit var progressText: TextView
    private lateinit var textViewQuestion: TextView
    private lateinit var imageViewFlag: ImageView

    private lateinit var textViewOptionOne: TextView
    private lateinit var textViewOptionTwo: TextView
    private lateinit var textViewOptionThree: TextView
    private lateinit var textViewOptionFour: TextView

    private lateinit var buttonCheck: Button

    private var questionsCounter = 0
    private lateinit var questionsList: MutableList<Question>
    private var selectedAnswer = 0
    private lateinit var currentQuestion: Question
    private var answered = false

    private lateinit var name: String
    private var score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        progressBar = findViewById(R.id.progress_bar)
        progressText = findViewById(R.id.text_view_progress)
        textViewQuestion = findViewById(R.id.question_text_view)
        imageViewFlag = findViewById(R.id.image_view)
        buttonCheck = findViewById(R.id.button_check)

        textViewOptionOne = findViewById(R.id.text_view_option_one)
        textViewOptionTwo = findViewById(R.id.text_view_option_two)
        textViewOptionThree = findViewById(R.id.text_view_option_three)
        textViewOptionFour = findViewById(R.id.text_view_option_four)

        textViewOptionOne.setOnClickListener(this)
        textViewOptionTwo.setOnClickListener(this)
        textViewOptionThree.setOnClickListener(this)
        textViewOptionFour.setOnClickListener(this)
        buttonCheck.setOnClickListener(this)

        questionsList = Constants.getQuestions()
        Log.d("QuestionSize", "${questionsList.size}")

        setQuestion()

        if (intent.hasExtra(Constants.USER_NAME)) {
            name = intent.getStringExtra(Constants.USER_NAME)!!
        }

    }

    private fun setQuestion() {

        if (questionsCounter < questionsList.size) {
            buttonCheck.text = "CHECK ANSWER"
            currentQuestion = questionsList[questionsCounter]

            resetOptions()
            val question = questionsList[questionsCounter]
            imageViewFlag.setImageResource(question.image)
            progressBar.progress = questionsCounter
            progressText.text = "$questionsCounter/${progressBar.max}"
            textViewQuestion.text = question.question
            textViewOptionOne.text = question.optionOne
            textViewOptionTwo.text = question.optionTwo
            textViewOptionThree.text = question.optionThree
            textViewOptionFour.text = question.optionFour
        } else {
            buttonCheck.text = "FINISH"
            Intent(this, Results::class.java).also {
                it.putExtra(Constants.USER_NAME, name)
                it.putExtra(Constants.CORRECT_ANSWERS, score)
                it.putExtra(Constants.TOTAL_QUESTIONS, questionsList.size)
                startActivity(it)
            }
        }

        questionsCounter++
        answered = false
    }

    private fun resetOptions() {
        val options = mutableListOf<TextView>()
        options.add(textViewOptionOne)
        options.add(textViewOptionTwo)
        options.add(textViewOptionThree)
        options.add(textViewOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }


    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.text_view_option_one -> {
                selectedOption(textViewOptionOne, 1)
            }

            R.id.text_view_option_two -> {
                selectedOption(textViewOptionTwo, 2)
            }

            R.id.text_view_option_three -> {
                selectedOption(textViewOptionThree, 3)
            }

            R.id.text_view_option_four -> {
                selectedOption(textViewOptionFour, 4)
            }

            R.id.button_check -> {
                if (!answered) {
                    checkAnswer()
                } else {
                    setQuestion()
                }
                selectedAnswer = 0
            }
        }
    }

    private fun selectedOption(textView: TextView, selectedOptionNumber: Int) {
        resetOptions()
        selectedAnswer = selectedOptionNumber

        textView.setTextColor(Color.parseColor("#363A43"))
        textView.typeface = Typeface.DEFAULT_BOLD
        textView.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    private fun checkAnswer() {
        answered = true
        if (selectedAnswer == currentQuestion.correctAnswer) {
            score++
            highlightAnswer(selectedAnswer)
        } else {
            when(selectedAnswer) {
                1 -> textViewOptionOne.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                2 -> textViewOptionTwo.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                3 -> textViewOptionThree.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                4 -> textViewOptionFour.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
            }
        }
        buttonCheck.text = "NEXT"
        showSolution()
    }

    private fun showSolution() {
        selectedAnswer = currentQuestion.correctAnswer
        highlightAnswer(selectedAnswer)
    }

    private fun highlightAnswer(answer: Int) {
        when (answer) {
            1 -> textViewOptionOne.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            2 -> textViewOptionTwo.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            3 -> textViewOptionThree.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            4 -> textViewOptionFour.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
        }
    }
}




