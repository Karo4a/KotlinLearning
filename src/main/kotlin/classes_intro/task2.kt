package classes_intro

fun task2() {
    println("Программа высчитывает расстояние между двумя введенными точками.")

    val a = inputPoint2("A")
    println()
    val b = inputPoint2("B")
    println()
    val length = Point2.length(a, b)

    println("Расстояние между точками A и B = $length")
}