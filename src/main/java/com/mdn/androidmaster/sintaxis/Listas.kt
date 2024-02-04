package com.mdn.androidmaster.sintaxis

fun main() {
    //inmutableList()
    mutableList()
}

fun inmutableList() {
    val weekDays: List<String> = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
    //println(weekDays.size)
    //println(weekDays)
    //println(weekDays[3])
    //println(weekDays.first())
    //println(weekDays.last())

    //Filtrar lista
    val daysWithA = weekDays.filter { weekDay -> weekDay.contains("a") }
    val daysWithE = weekDays.filter { it.contains("e") }
    //println(daysWithA)
    //println(daysWithE)

    //Recorrer lista
    //weekDays.forEach { println(it) }
    weekDays.forEach { weekDay -> println(weekDay) }

}

fun mutableList() {
    var names:MutableList<String> = mutableListOf()

    if(names.isEmpty()){
        println("La lista está vacía")
    }   else{
        println(names)
    }
    
    names = mutableListOf("Mario","Toni","Dani","Rodri")

    if(names.isNotEmpty()){
        println(names)
    }   else{
        println("La lista está vacía")
    }

    names.add("Igna")
    names.add(0,"Gomis")
    print(names)
    
}