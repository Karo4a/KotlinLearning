package classes_intro

import classes_intro.classes.Circle
import classes_intro.classes.Triangle
import common.roundToString

fun task4() {
    println("Программа высчитывает описанную вокруг треугольника окружность.")

    val a = inputPoint2("A")
    println()
    val b = inputPoint2("B")
    println()
    val c = inputPoint2("С")
    println()
    val triangle = Triangle(a, b, c)

    val circumcircle = Circle.circumcircle(triangle)
    if (circumcircle != null) {
        println("Описанная окружность:")
        println("Центр = (${circumcircle.center.x.roundToString(4)}, ${circumcircle.center.y.roundToString(4)})")
        println("Радиус = ${circumcircle.radius.roundToString(4)}")
    } else {
        println("Вершины треугольника находятся на одной прямой. Найти описанную окружность невозможно.")
    }
}