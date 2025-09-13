fun main() {
    println("Сборник программ по Kotlin.")
    println("Темы: \n" +
            "1 - Основы")

    print("Выберите тему: ")
    var choice = readln().toIntOrNull()

    if (choice != null) {
        when (choice) {
            1 -> {
                println("\nЗадачи: \n" +
                        "1 - Задача 1\n" +
                        "2 - Задача 2\n" +
                        "3 - Задача 3\n" +
                        "4 - Задача 4\n" +
                        "5 - Задача 5\n" +
                        "6 - Задача 6")

                print("Выберите задачу: ")
                choice = readln().toIntOrNull()

                if (choice != null) {
                    println()
                    when (choice) {
                        1 -> basics.first()
                        2 -> basics.second()
                        3 -> basics.third()
                        4 -> basics.fourth()
                        5 -> basics.fifth()
                        6 -> basics.sixth()
                        else -> {
                            print("Неправильный выбор задачи.")
                        }
                    }
                } else {
                    println("Некорректный ввод.")
                }
            }
            else -> {
                println("Неправильный выбор темы.")
            }
        }
    } else {
        println("Некорректный ввод.")
    }
}