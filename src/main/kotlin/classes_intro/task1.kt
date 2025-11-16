package classes_intro

fun task1() {
    println("Программа высчитывает находится ли введенная точка внутри произвольного треугольника.\n")

    val a = inputPoint("A")
    val b = inputPoint("B")
    val c = inputPoint("С")
    val triangle = Triangle(a, b, c)

    val point = inputPoint("для проверки её расположения внутри треугольника")
    println(
        if (triangle.isPointInTriangle(point)) "Указанная точка находится внутри треугольника "
        else "Указанная точка лежит вне треугольника")
}