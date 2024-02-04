package com.mdn.androidmaster.sintaxis

//Mi primer archive Kotlin

fun main() {
    ShowMyName()
    ShowMyInputAge(25)
    add(33, 1)
    val substResult = substract(99, 20)
    println(substResult)
}

fun variablesNumericas() {
    //Int (Integers)
    var age: Int = 25

    //Long (LongIntegers)
    var ageOfUniverse: Long = 9832382983

    //Float (Decimal)
    var floatExample: Float = 1.5f

    //Double (Long Decimal)
    var doubleExample: Double = 32423.213413
}

fun variablesAlfanumericas() {
    //Char (Character)
    var charExample: Char = 'm'
    var charExample2: Char = '@'
    var charExample3: Char = '7'
    var charExample4: Char = '/'

    //String
    var stringExample: String = "Mario está aprendiendo"
    var stringExample2: String = "a programar en Kotlin"

    //Boolean
    var booleanExample: Boolean = true
    var booleanExample2: Boolean = false

    //Cast (toX  X=Int,Char,Float...)

    //Concat
    println(stringExample + " " + stringExample2)
    println("Mi frase concatenada es $stringExample $stringExample2")
}

//Funciones básicas
fun ShowMyName() {
    println("Me llamo Mario")
}

//Funciones con parámetros de entrada
fun ShowMyInputAge(age: Int = 55) {
    println("Tengo $age años")
}

fun add(a: Int, b: Int) {
    val result: Int = a + b
    println("La suma de los parámetros de entrada es: $result")
}

//Funciones con parámetros de salida
fun substract(a: Int, b: Int): Int {
    return a - b
}

fun substractCool(a: Int, b: Int): Int = a - b

fun substractCool2(a: Int, b: Int) = a - b
