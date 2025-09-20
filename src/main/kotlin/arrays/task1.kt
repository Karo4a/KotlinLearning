package arrays

import kotlin.math.abs

fun task1() {
    println("Программа выводит кол-во использованных различных цифр в введенной матрице трехзначных чисел.")
    println("Ручной ввод чисел в матрицу!")

    print("Количество строк в матрице: ")
    val sizeRows = readln().toUIntOrNull()
    if (sizeRows != null) {
        print("Количество столбцов в матрице: ")
        val sizeCols = readln().toUIntOrNull()
        if (sizeCols != null) {
            println("Вводите только трехзначные числа!")
            val matrix = arrayOfNulls<Array<Int?>>(sizeRows.toInt())
            for (i in 0 until sizeRows.toInt()) {
                val row = arrayOfNulls<Int>(sizeCols.toInt())
                for (j in 0 until sizeCols.toInt()) {
                    var inputEl : Int?
                    do {
                        print("arr[$i][$j] = ")
                        inputEl = readln().toIntOrNull()
                        val isValid = inputEl != null && abs(inputEl) in 100..999
                        if (!isValid) {
                            println("Введите корректное трехзначное число!")
                        }
                    } while (!isValid)
                    row[j] = inputEl
                }
                matrix[i] = row
            }

            val typedMatrix = matrix.map{ row -> row.orEmpty()}.orEmpty().toTypedArray()
            typedMatrix.forEach { row -> println(row.joinToString(" ")) }
            val countOfUniqueDigits = typedMatrix.flatten().joinToString("").toSet().size
            println("В матрице используется $countOfUniqueDigits различных цифр")
        } else {
            println("Некорректный ввод количества столбцов!")
        }
    } else {
        println("Некорректный ввод количества строк!")
    }
}