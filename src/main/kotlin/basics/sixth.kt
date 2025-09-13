package basics

fun sixth() {
    println("Программа проверяет возможно ли из двух введенных цифр составить нечетное число.")
    print("Введите цифру 1: ")
    val num1 = readln().toIntOrNull()
    if (num1 != null) {
        print("Введите цифру 2: ")
        val num2 = readln().toIntOrNull()
        if (num2 != null) {
            val numSet = setOf(num1, num2)
            val cartesianProduct = numSet.flatMap { x -> numSet.map{ y -> "$x$y".toInt() } }
            var isOdd = false
            for (num in cartesianProduct) {
                if (num % 2 != 0) {
                    println("Нечетное число: $num")
                    isOdd = true
                    break
                }
            }
            if (!isOdd) {
                println("Создать нечетное число невозможно.")
            }
        } else {
            println("Некорректный ввод цифры 2!")
        }
    } else {
        println("Некорректный ввод цифры 1!")
    }
}