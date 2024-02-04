package com.mdn.androidmaster.secondApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.mdn.androidmaster.R
import com.mdn.androidmaster.secondApp.CompanionObjects.Companion.IMC_KEY

class SecondAppActivity : AppCompatActivity() {

    private lateinit var maleCardView: CardView
    private lateinit var femaleCardView: CardView
    private lateinit var textViewHeight: TextView
    private lateinit var rangeSliderHeight: RangeSlider
    private lateinit var floatingButtonSubstractWeight: FloatingActionButton
    private lateinit var floatingButtonAddWeight: FloatingActionButton
    private lateinit var textViewWeight: TextView
    private lateinit var floatingButtonSubstractAge: FloatingActionButton
    private lateinit var floatingButtonAddAge: FloatingActionButton
    private lateinit var textViewAge: TextView
    private lateinit var buttonCalculate: Button

    private var selectedCardViewColor: Int = 0
    private var unselectedCardViewColor: Int = 0

    private var isMaleSelected: Boolean = true
    private var currentHeight: Int = 120
    private var currentWeight: Int = 70
    private var currentAge: Int = 30
    private var userIMC: Double = 10.00



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_app)
        initComponents()
        initColors()
        initListeners()
    }

    //Inicializamos los componentes
    private fun initComponents() {
        maleCardView = findViewById(R.id.maleCardView)
        femaleCardView = findViewById(R.id.femaleCardView)
        textViewHeight = findViewById(R.id.textViewHeight)
        rangeSliderHeight = findViewById(R.id.rangeSliderHeight)
        floatingButtonSubstractWeight = findViewById(R.id.floatingButtonSubstractWeight)
        floatingButtonAddWeight = findViewById(R.id.floatingButtonAddWeight)
        textViewWeight = findViewById(R.id.textViewWeight)
        floatingButtonSubstractAge = findViewById(R.id.floatingButtonSubstractAge)
        floatingButtonAddAge = findViewById(R.id.floatingButtonAddAge)
        textViewAge = findViewById(R.id.textViewAge)
        buttonCalculate = findViewById(R.id.buttonCalculate)
    }

    //Inicializamos los colores
    private fun initColors() {
        selectedCardViewColor = ContextCompat.getColor(this, R.color.background_component_selected)
        unselectedCardViewColor = ContextCompat.getColor(this, R.color.background_component)
    }

    //Inicializamos los listeners para los componentes
    private fun initListeners() {
        maleCardView.setOnClickListener {
            setIsMaleSelected(true)
            setGenderCardViewBackgroundColor()
        }
        femaleCardView.setOnClickListener {
            setIsMaleSelected(false)
            setGenderCardViewBackgroundColor()
        }
        rangeSliderHeight.addOnChangeListener { _, value, _ ->
            setHeight(value)
        }
        floatingButtonSubstractWeight.setOnClickListener {
            setWeight(currentWeight - 1)
        }
        floatingButtonAddWeight.setOnClickListener {
            setWeight(currentWeight + 1)
        }
        floatingButtonSubstractAge.setOnClickListener {
            setAge(currentAge - 1)
        }
        floatingButtonAddAge.setOnClickListener {
            setAge(currentAge + 1)
        }
        buttonCalculate.setOnClickListener {
            calculateIMC()
            navigateToResult()
        }
    }

    //Setter para IsMaleSelected
    private fun setIsMaleSelected(isSelected: Boolean) {
        isMaleSelected = isSelected
    }

    //Cambiamos el color de las CardView en función del valor de isMaleSelected
    private fun setGenderCardViewBackgroundColor() {
        if (isMaleSelected) {
            maleCardView.setCardBackgroundColor(selectedCardViewColor)
            femaleCardView.setCardBackgroundColor(unselectedCardViewColor)
        } else {
            femaleCardView.setCardBackgroundColor(selectedCardViewColor)
            maleCardView.setCardBackgroundColor(unselectedCardViewColor)
        }
    }

    //Setter para el texto interior del textViewHeigh
    private fun setHeight(value: Float) {
        currentHeight = value.toInt()
        textViewHeight.text = "$currentHeight cm"
    }

    //Setter para el texto interior del textViewWeight
    private fun setWeight(newWeight: Int) {
        currentWeight = newWeight
        if (currentWeight < 20) {
            currentWeight = 20
        }
        textViewWeight.text = "$currentWeight"
    }

    //Setter para el texto interior del textViewAge
    private fun setAge(newAge: Int) {
        currentAge = newAge
        if (currentAge < 0) {
            currentAge = 0
        }
        textViewAge.text = "$currentAge"
    }

    private fun calculateIMC() {
        userIMC = currentWeight / (currentHeight.toDouble() / 100 * currentHeight.toDouble() / 100)
    }

    private fun navigateToResult(){
        val intent = Intent(this, SecondAppResult::class.java)
        intent.putExtra(IMC_KEY, userIMC)
        startActivity(intent)
    }

}