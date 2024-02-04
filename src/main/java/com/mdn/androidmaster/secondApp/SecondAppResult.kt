package com.mdn.androidmaster.secondApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.mdn.androidmaster.R
import com.mdn.androidmaster.secondApp.CompanionObjects.Companion.IMC_KEY

class SecondAppResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_app_result)

        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0

        val textViewResult: TextView = findViewById(R.id.textViewResult)
        textViewResult.text =  String.format("%.2f", result)

        val textViewInfoMessage: TextView = findViewById(R.id.textViewInfoMessage)

        when(result){
            in 0.00..18.50 -> {textViewInfoMessage.text = getString(R.string.LowWeight)}
            in 18.51..24.99 -> {textViewInfoMessage.text = getString(R.string.OkWeight)}
            in 25.00..29.99 -> {textViewInfoMessage.text = getString(R.string.BadWeight)}
            in 30.00..99.99 -> {textViewInfoMessage.text = getString(R.string.VeryBadWeight)}
            else -> {textViewInfoMessage.text = getString(R.string.ErrorWeight)}
        }

    }
}