package com.mdn.androidmaster.sintaxis


//Exercise 3: Conditionals
fun gptExercise3(number: Int) {
    if (number < 0) {
        println("$number is negative")
    } else if (number > 0) {
        println("$number is positive")
    } else {
        println("$number is 0")
    }
}

fun gptExercise3v2(number: Int) {
    var number2: Int = -33
    when {
        number2 < 0 -> println("$number2 is negative")
        number2 > 0 -> println("$number2 is positive")
        else -> println("$number2 is 0")
    }
}

//Exercise 4: Loops
fun gptExercise4() {
    var result: Int
    for (i in 1..10) {
        result = i * i
        println(result)
    }
}

//Exercise 5: Functions
fun gptExercise5(a: Int, b: Int): Int = a * b

//Exercise 6: List and Iteration
fun gptExercise6() {
    var favMovies: List<String> = mutableListOf("Movie 1", "Movie 2", "Movie 3", "Movie 4")
    favMovies.forEach { movie -> println(movie) }
}

//Exercise 7: String Manipulation
fun gptExercise7(sentence: String) {
    var numberOfVowels: Int = 0
    sentence.uppercase().forEach { currentChar ->
        when (currentChar.uppercaseChar()) {
            'A', 'E', 'I', 'O', 'U' -> numberOfVowels += 1
        }
    }
    print(numberOfVowels)
}

fun main() {
    var car = Car("Toyota", "Prius", 2019)


    println(car.maker)
    println(car.model)
    println(car.year)

    car.displayDetails()

}


class Car(private var _maker: String, private var _model: String, private var _year: Int) {

    var maker: String
        get() = _maker
        set(value) {
            _maker = value
        }

    var model: String
        get() = _model
        set(value) {
            _model = value
        }

    var year: Int
        get() = _year
        set(value) {
            _year = value
        }

    fun displayDetails() {
        println("Car Details: $_year $_maker $_model")
    }
}

