package com.mdn.androidmaster.firstApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.mdn.androidmaster.R
import kotlin.math.log

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)

        val btnSend = findViewById<Button>(R.id.btnSend)
        var editText = findViewById<EditText>(R.id.editTextMssgToSend)

        btnSend.setOnClickListener{
            val userName:String = editText.text.toString().trim()
            if (userName.isEmpty()){
                Log.i("btnSendClicked", "No hay texto")
            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_userName", userName)
                startActivity(intent)
            }

        }

    }
}