package classes_intro

import classes_intro.classes.Point2
import common.roundToString

fun task3() {
    println("Программа высчитывает наименьшее и наибольшее растояние между множеством точек.")

    val quantity = inputInt("количество точек",
        "Введите целое число больше 2."
    ) { it > 2 }
    println()
    val points = mutableListOf<Point2>()

    for (i in 1..quantity) {
        do {
            val point = inputPoint2(i.toString())
            val condition = points.contains(point)
            if (condition) {
                println("Множество уже содержит такую точку!")
            } else {
                points.add(point)
            }
            println()
        } while(condition)
    }

    val lengths = mutableMapOf<Double, List<Point2>>()
    while (points.isNotEmpty()) {
        val fromPoint = points.removeFirst()
        for (toPoint in points) {
            val distance = Point2.length(fromPoint, toPoint)
            lengths[distance] = listOf(fromPoint, toPoint)
        }
    }
    val sortedLengths = lengths.toSortedMap()
    val minLength = sortedLengths.entries.first()
    val maxLength = sortedLengths.entries.last()

    println("Минимальное расстояние = ${minLength.key.roundToString(4)} между ${minLength.value.joinToString(" и ")} ")
    println("Максимальное расстояние = ${maxLength.key.roundToString(4)} между ${maxLength.value.joinToString(" и ")} ")
}