package basics

fun task6() {
    println("Программа проверяет возможно ли из двух введенных цифр составить нечетное число.")
    print("Введите цифру 1: ")
    val num1 = readln().toIntOrNull()
    if (num1 != null && num1 in 0..9) {
        print("Введите цифру 2: ")
        val num2 = readln().toIntOrNull()
        if (num2 != null && num2 in 0..9) {
            if (num2 % 2 != 0) {
                println("Нечетное число: $num1$num2")
            } else if (num1 % 2 != 0) {
                println("Нечетное число: $num2$num1")
            } else {
                println("Создать нечетное число невозможно.")
            }
        } else {
            println("Некорректный ввод цифры 2!")
        }
    } else {
        println("Некорректный ввод цифры 1!")
    }
}