package basics

fun task4() {
    println("Программа является калькулятором. Формат ввода: ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ.")
    print("Введите число: ")
    val (strA, strB, operation) = readln().split(" ", limit=4)
    val numA = strA.toDoubleOrNull()
    if (numA != null) {
        val numB = strB.toDoubleOrNull()
        if (numB != null) {
            if (operation == "/" && numB == 0.0) {
                println("Деление на ноль!")
            } else {
                val result = when (operation) {
                    "+" -> numA + numB
                    "-" -> numA - numB
                    "*" -> numA * numB
                    "/" -> numA / numB
                    else -> null
                }

                if (result == null) {
                    println("Операция имеет некорректный ввод.")
                } else {
                    println("Результат = " +
                            if (result % 1.0 == 0.0) result.toInt() else result)
                }
            }
        } else {
            println("Число 2 имеет некорретный ввод.")
        }
    } else {
        println("Число 1 имеет некорретный ввод.")
    }
}