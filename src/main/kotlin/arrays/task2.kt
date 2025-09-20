package arrays

import kotlin.math.abs

fun task2() {
    println("Программа проверяет симметрична ли матрица относительно главной диагонали.")
    println("Ручной ввод чисел в матрицу!")

    print("Размер квадратной матрицы: ")
    val sizeMatrix = readln().toUIntOrNull()
    if (sizeMatrix != null) {
        println("Вводите только однозначные числа!")
        val matrix = arrayOfNulls<Array<Int?>>(sizeMatrix.toInt())
        for (i in 0 until sizeMatrix.toInt()) {
            val row = arrayOfNulls<Int>(sizeMatrix.toInt())
            for (j in 0 until sizeMatrix.toInt()) {
                var inputEl : Int?
                do {
                    print("arr[$i][$j] = ")
                    inputEl = readln().toIntOrNull()
                    val isValid = inputEl != null && abs(inputEl) in 1..9
                    if (!isValid) {
                        println("Введите корректное однозначное число!")
                    }
                } while (!isValid)
                row[j] = inputEl
            }
            matrix[i] = row
        }

//        for (n in 0..sizeMatrix*(sizeMatrix+1)/2)) {
//
//        }

        val typedMatrix = matrix.map{ row -> row.orEmpty()}.orEmpty().toTypedArray()
        typedMatrix.forEach { row -> println(row.joinToString(" ")) }
        val countOfUniqueDigits = typedMatrix.flatten().joinToString("").toSet().size
        println("В матрице используется $countOfUniqueDigits различных цифр")
    } else {
        println("Некорректный ввод размера квадратной матрицы!")
    }
}