package com.mdn.androidmaster.firstApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.mdn.androidmaster.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textViewUserName = findViewById<TextView>(R.id.textViewUserName)
        val name: String = intent.extras?.getString("EXTRA_userName").orEmpty()

        textViewUserName.text = "Hola, $name"
    }
}