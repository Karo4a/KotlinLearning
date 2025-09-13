package basics

fun second() {
    println("Программа подсчитывает количество различных символов во введенной строке.")
    print("Введите строку: ")
    val input = readln()
    val resultMap = mutableMapOf<String, Int>()
    input.toSet().forEach{ x -> resultMap["$x"] = input.count{ y -> x == y }}
    resultMap.toSortedMap().forEach{ (key, value) -> println("$key - $value") }
}