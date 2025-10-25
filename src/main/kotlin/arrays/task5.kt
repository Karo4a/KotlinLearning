package arrays

fun task5() {
    println("Программа группирует слова введенные пользователем по признаку 'состоят из одинаковых букв'")

    print("Введите количество вводимых слов: ")
    val quantityU = readln().toUIntOrNull()
    if (quantityU != null) {
        val quantity = quantityU.toInt()
        val words = mutableListOf<String>()

        for (i in 0..quantity-1) {
            print("Слово ${i+1} = ")
            words.add(readln())
        }
        println(words)

    } else {
        println("Некорректный ввод!")
    }
}