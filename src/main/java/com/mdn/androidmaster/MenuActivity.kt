package com.mdn.androidmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mdn.androidmaster.firstApp.FirstAppActivity
import com.mdn.androidmaster.secondApp.SecondAppActivity
import com.mdn.androidmaster.thirdApp.ThirdAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnFirstApp = findViewById<Button>(R.id.btnFirstApp)
        btnFirstApp.setOnClickListener{
            navigateToApp(1)
        }

        val btnSecondApp = findViewById<Button>(R.id.btnSecondApp)
        btnSecondApp.setOnClickListener{
            navigateToApp(2)
        }

        val btnThirdApp = findViewById<Button>(R.id.btnThirdApp)
        btnThirdApp.setOnClickListener{
            navigateToApp(3)
        }
    }

    private fun navigateToApp(app: Int){
        when(app){
            1 -> startActivity((Intent(this, FirstAppActivity::class.java)))
            2 -> startActivity((Intent(this, SecondAppActivity::class.java)))
            3 -> startActivity((Intent(this, ThirdAppActivity::class.java)))
        }

    }
}