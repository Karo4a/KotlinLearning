package classes_intro

import classes_intro.classes.Point2

fun inputInt(inputName : String,
             errorString : String = "Введите целое число.",
             predicate : (Int) -> Boolean = { true }) : Int
{
    var num : Int?
    do {
        print("Введите $inputName: ")
        num = readln().toIntOrNull()
        val condition = num == null || !predicate(num)
        if (condition) {
            println("Неправильно! $errorString\n")
        }
    } while(condition)
    return num!!
}

fun inputDouble(inputName : String,
                errorString : String = "Введите вещественное число.",
                predicate : (Double) -> Boolean = { true }) : Double
{
    var num : Double?
    do {
        print("Введите $inputName: ")
        num = readln().toDoubleOrNull()
        val condition = num == null || !predicate(num)
        if (condition) {
            println("Неправильно! $errorString\n")
        }
    } while(condition)
    return num!!
}

fun inputPoint2(pointName : String) : Point2 {
    println("Заполним точку $pointName:")
    return Point2(
        inputDouble("координату x"),
        inputDouble("координату y")
    )
}