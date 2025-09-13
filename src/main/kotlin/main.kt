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
                        1 -> basics.task1()
                        2 -> basics.task2()
                        3 -> basics.task3()
                        4 -> basics.task4()
                        5 -> basics.task5()
                        6 -> basics.task6()
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