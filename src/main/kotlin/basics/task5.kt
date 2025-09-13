package basics

import kotlin.math.log

fun task5() {
    println("Программа проверяет существует ли для числа 'n' и основания степени 'x' целочисленный показатель степени 'y'" +
            " для которого выполняется равенство x^y = n.")
    print("Введите n и x (через пробел): ")
    val (strN, strX) = readln().split(" ", limit=3)
    val n = strN.toIntOrNull()
    if (n != null) {
        val x = strX.toIntOrNull()
        if (x != null) {
            val y = log(n.toDouble(), x.toDouble())
            if (y % 1.0 == 0.0) {
                println("Целочисленные показатель y = ${y.toInt()}")
            } else {
                println("Целочисленного показателя не существует.")
            }
        } else {
            println("Число x должно быть целочисленным!")
        }
    } else {
        println("Число n должно быть целочисленным!")
    }
}