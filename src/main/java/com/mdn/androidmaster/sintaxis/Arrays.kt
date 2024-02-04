package com.mdn.androidmaster.sintaxis

var weekDays = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")

fun main(){
    //getWeekDay(0)
    getAllWeekDays3()
}

fun getWeekDay(day:Int){
    println(weekDays[day])
}

//Recorremos y sacamos el valor
fun getAllWeekDays(){
    for (day in weekDays){
        println(day)
    }
}

//Recorremos y sacamos el valor mediante su posición
fun getAllWeekDays2(){
    for (position in weekDays.indices){
        println(weekDays[position])
    }
}

//Recorremos y sacamos el valor y su posición
fun getAllWeekDays3(){
    for ((position, value) in weekDays.withIndex()){
        println("La posición $position tiene el valor: $value.")
    }

    weekDays.forEach { day -> print(day) }
}