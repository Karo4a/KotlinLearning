package arrays

import kotlin.math.abs

fun task2() {
    println("Программа проверяет симметрична ли матрица относительно главной диагонали.")
    println("Ручной ввод чисел в матрицу!")

    print("Размер квадратной матрицы: ")
    val sizeMatrixU = readln().toUIntOrNull()
    if (sizeMatrixU != null) {
        val sizeMatrix = sizeMatrixU.toInt()
        println("Вводите только однозначные числа!")
        val matrix = arrayOfNulls<Array<Int?>>(sizeMatrix)
        for (i in 0 until sizeMatrix) {
            val row = arrayOfNulls<Int>(sizeMatrix)
            for (j in 0 until sizeMatrix) {
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

        val typedMatrix = matrix.map{ row -> row.orEmpty()}.toTypedArray()
        var isSymmetric = true
        for (i in 0 until matrix.lastIndex) {
            for (j in i+1..matrix.lastIndex) {
                if (typedMatrix[i][j] != typedMatrix[j][i]) {
                    isSymmetric = false
                    break
                }
            }
            if (!isSymmetric) {
                break
            }
        }

        typedMatrix.forEach { row -> println(row.joinToString(" ")) }
        println(if(isSymmetric) "Матрица симметрична относительно главной диагонали"
                else "Матрица не симметрична относительно главной диагонали")
        print("Продолжить на Enter...")
        readln()
    } else {
        println("Некорректный ввод размера квадратной матрицы!")
    }
}