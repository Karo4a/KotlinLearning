package classes_intro

import classes_intro.classes.Triangle

fun task1() {
    println("Программа высчитывает находится ли введенная точка внутри произвольного треугольника.\n")

    val a = inputPoint2("A")
    println()
    val b = inputPoint2("B")
    println()
    val c = inputPoint2("С")
    println()
    val triangle = Triangle(a, b, c)

    val point = inputPoint2("для проверки её расположения внутри треугольника")
    println(
        if (triangle.isPointInTriangle(point)) "Указанная точка находится внутри треугольника"
        else "Указанная точка лежит вне треугольника")
}