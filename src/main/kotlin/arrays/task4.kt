package arrays

import kotlin.math.min

fun task4() {
    println("Программа выводит пересечение двух массивов введенных пользователем.")

    val firstList = mutableListOf<Int>()
    val secondList = mutableListOf<Int>()

    println("Заполним первый массив целыми числами. Пустая строка - конец ввода массива")
    do {
        print("Элемент ${firstList.size+1} = ")
        val input = readln()
        val inputInt = input.toIntOrNull()

        if (inputInt != null) {
            firstList.add(inputInt)
        } else if (input != "") {
            println("Целые числа попадают в массив, пустая строка означает конец ввода массива!")
        }

    } while(input != "")

    println("Заполним второй массив целыми числами. Пустая строка - конец ввода массива")
    do {
        print("Элемент ${secondList.size+1} = ")
        val input = readln()
        val inputInt = input.toIntOrNull()

        if (inputInt != null) {
            secondList.add(inputInt)
        } else if (input != "") {
            println("Целые числа попадают в массив, пустая строка означает конец ввода массива!")
        }

    } while(input != "")

    println("Первый массив: $firstList")
    println("Второй массив: $secondList")

    val intersectionResult = mutableListOf<Int>()
    val firstSet = firstList.toSet()
    val secondSet = secondList.toSet()
    val firstDictNumToCount = firstSet.zip(firstSet.map{ firstList.count{ x -> x == it } }).toMap()
    val secondDictNumToCount = secondSet.zip(secondSet.map{ secondList.count{ x -> x == it } }).toMap()
    for ((num, count) in firstDictNumToCount.toSortedMap()) {
        val secondCount = secondDictNumToCount[num]
        if (secondCount != null) {
            for (i in 0 until min(count, secondCount)) {
                intersectionResult.add(num)
            }
        }
    }
    println("Пересечение массивов:\n${intersectionResult}")
    print("Продолжить на Enter...")
    readln()
}