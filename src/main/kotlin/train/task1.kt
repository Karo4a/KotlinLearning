package train

import common.pressToContinue

fun task1() {
    do {
        println("Программа составляет план поезда.")
        println("Вы хотите составить поезд? EXIT чтобы выйти.")
        print("Ввод = ")
        val input = readln()
        println()

        if (input != "EXIT") {
            val train = Train()

            println("Шаг 1 - Составляем направление.")
            println("Направление поезда: ${train.route.info()}")
            pressToContinue()
            println()

            println("Шаг 2 - Продаём билеты.")
            println("Куплено билетов: ${train.passengers} шт.")
            pressToContinue()
            println()

            println("Шаг 3 - Формируем поезд.")
            println("Итого вагонов: ${train.carriages.size}")
            pressToContinue()
            println()

            println("Шаг 4 - Отправляем поезд.")
            println("Поезд ${train.route.info()}, состоящий из ${train.carriages.size} вагонов отправлен.")
            println("Вагоны:")
            for (i in 0..train.carriages.lastIndex) {
                println("Вагон ${i+1} = ${train.carriages[i].info()}")
            }
            pressToContinue()
            println()
        }
    } while (input != "EXIT")
}