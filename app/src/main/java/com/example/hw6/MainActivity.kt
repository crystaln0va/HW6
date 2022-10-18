package com.example.hw6

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    var score: Int = 0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submit.setOnClickListener{

            if (q2a2.isChecked && q2a3.isChecked) score += 50
            if (q1a2.isChecked) score += 50

            val current = LocalDateTime.now()

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Result")
            builder.setMessage("Congratulations! You submitted on $current, you achieved score of $score%")


            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

        reset.setOnClickListener {
            radioGroup.clearCheck()
            q2a1.clearFocus()
            q2a2.clearFocus()
            q2a3.clearFocus()
            score = 0
        }
    }
}