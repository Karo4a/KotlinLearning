package classes_intro

import classes_intro.classes.Circle
import classes_intro.classes.Triangle
import common.roundToString

fun task5() {
    println("Программа высчитывает вписанную в треугольник окружность.")

    val a = inputPoint2("A")
    println()
    val b = inputPoint2("B")
    println()
    val c = inputPoint2("С")
    println()
    val triangle = Triangle(a, b, c)

    val incircle = Circle.incircle(triangle)
    if (incircle != null) {
        println("Вписанная окружность:")
        println("Центр = (${incircle.center.x.roundToString(4)}, ${incircle.center.y.roundToString(4)})")
        println("Радиус = ${incircle.radius.roundToString(4)}")
    } else {
        println("Вершины треугольника находятся на одной прямой. Найти вписанную окружность невозможно.")
    }
}