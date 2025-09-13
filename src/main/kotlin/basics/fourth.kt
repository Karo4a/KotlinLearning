package basics

fun fourth() {
    println("Программа является калькулятором. Формат ввода: ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ.")
    print("Введите число: ")
    val (strA, strB, operation) = readln().split(" ", limit=4)
    val numA = strA.toIntOrNull()
    if (numA != null) {
        val numB = strB.toIntOrNull()
        if (numB != null) {
            when (operation) {
                "+" -> println("Результат = ${numA + numB}")
                "-" -> println("Результат = ${numA - numB}")
                "*" -> println("Результат = ${numA * numB}")
                "/" -> println(if (numB == 0) "Деление на ноль!" else "Результат = ${numA / numB}")
                else -> println("Операция имеет некорректный ввод.")
            }
        } else {
            println("Число 2 имеет некорретный ввод.")
        }
    } else {
        println("Число 1 имеет некорретный ввод.")
    }
}