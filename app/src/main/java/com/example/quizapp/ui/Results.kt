package com.example.quizapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.MainActivity
import com.example.quizapp.R
import com.example.quizapp.utils.Constants

class Results : AppCompatActivity() {

    private lateinit var textViewName: TextView
    private lateinit var textViewScore: TextView
    private lateinit var buttonFinish: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        textViewName = findViewById(R.id.textview_name)
        textViewScore = findViewById(R.id.textview_score)
        buttonFinish = findViewById(R.id.finish_button)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val score = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val name = intent.getStringExtra(Constants.USER_NAME)

        textViewScore.text = "Your Score is $score out of $totalQuestions"
        textViewName.text = name

        buttonFinish.setOnClickListener {
            intent = Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}