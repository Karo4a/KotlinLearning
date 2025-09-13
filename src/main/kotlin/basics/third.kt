package basics

fun third() {
    println("Программа преобразует введенное пользователем натуральное число из 10-ичной системы в двоичную.")
    print("Введите число: ")
    val input = readln().toIntOrNull()
    if (input != null) {
        println("Результат = ${Integer.toBinaryString(input)}")
    } else {
        println("Некорректный ввод!")
    }
}