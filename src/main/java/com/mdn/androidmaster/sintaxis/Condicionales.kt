package com.mdn.androidmaster.sintaxis

fun main() {
    getTrimestre(13)
}


fun ifBasico() {
    val name: String = "Mario"

    if (name == "Mario") {
        println("El usuario se llama $name")
    } else {
        println("El usuario no se llama Mario")
    }
}


fun elseIf() {
    val animal: String = "Bear"

    if (animal == "Bird") {
        println("El animal es un pájaro")
    } else if (animal == "Dog") {
        println("El animal es un perrete")
    } else if (animal == "Cat") {
        println("El animal es un gatete")
    } else {
        println("No es ni pájarito, ni perrete y tampoco un gatete :(")
    }
}

fun getMonth(month: Int) {
    when (month) {
        1 -> println("Enero")
        2 -> println("Febrero")
        3 -> println("Marzo")
        4 -> println("Abril")
        5 -> println("Mayo")
        6 -> println("Junio")
        7 -> println("Julio")
        8 -> println("Agosto")
        9 -> println("Septiembre")
        10 -> println("Octubre")
        11 -> println("Noviembre")
        12 -> {
            println("Diciembre")
            println("Dos prints en el when")
        }

        else -> println("Mes no válido")
    }
}


fun getTrimestre(month: Int) {
    when (month) {
        1, 2, 3 -> println("Primer Trimestre")
        4, 5, 6 -> println("Segundo Trimestre")
        7, 8, 9 -> println("Tercer Trimestre")
        10, 11, 12 -> println("Cuarto Trimestre")
        !in 1..12 -> println("No es un trimestre válido")
    }
}

fun getSemestre(month: Int) {
    when (month) {
        in 1..6 -> println("Primer Semestre")
        in 7..12 -> println("Segundo Semestre")
        !in 1..12 -> println("No es un semestre válido")
    }
}

fun getSemestre2(month: Int):String = when (month) {
    in 1..6 -> "Primer Semestrer"
    in 7..12 -> "Segundo Semestre"
    else -> "No es un semestre válido"
    }

