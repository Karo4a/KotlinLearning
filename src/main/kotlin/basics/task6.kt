package basics

fun task6() {
    println("Программа проверяет возможно ли из двух введенных цифр составить нечетное число.")
    print("Введите цифру 1: ")
    val num1 = readln().toUIntOrNull()
    if (num1 != null && num1 < 10u) {
        print("Введите цифру 2: ")
        val num2 = readln().toUIntOrNull()
        if (num2 != null && num2 < 10u) {
            if ("$num1$num2".toInt() % 2 != 0) {
                println("Нечетное число: $num1$num2")
            } else if ("$num2$num1".toInt() % 2 != 0) {
                println("Нечетное число: $num2$num1")
            } else {
                println("Создать нечетное число невозможно.")
            }
//            val numSet = setOf(num1, num2)
//            val cartesianProduct = numSet.flatMap { x -> numSet.map{ y -> "$x$y".toInt() } }
//            var isOdd = false
//            for (num in cartesianProduct) {
//                if (num % 2 != 0) {
//                    println("Нечетное число: $num")
//                    isOdd = true
//                    break
//                }
//            }
//            if (!isOdd) {
//                println("Создать нечетное число невозможно.")
//            }
        } else {
            println("Некорректный ввод цифры 2!")
        }
    } else {
        println("Некорректный ввод цифры 1!")
    }
}