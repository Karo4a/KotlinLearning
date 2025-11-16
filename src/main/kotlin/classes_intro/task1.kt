package classes_intro

fun task1() {
    println("Программа высчитывает находится ли введенная точка внутри произвольного треугольника.\n")

    val a = inputPoint2("A")
    val b = inputPoint2("B")
    val c = inputPoint2("С")
    val triangle = Triangle(a, b, c)

    val point = inputPoint2("для проверки её расположения внутри треугольника")
    println(
        if (triangle.isPointInTriangle(point)) "Указанная точка находится внутри треугольника"
        else "Указанная точка лежит вне треугольника")
}