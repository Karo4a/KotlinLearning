package arrays

fun task5() {
    println("Программа группирует слова введенные пользователем по признаку 'состоят из одинаковых букв'")

    print("Введите количество вводимых слов: ")
    val quantityU = readln().toUIntOrNull()
    if (quantityU != null) {
        val quantity = quantityU.toInt()
        val words = mutableListOf<String>()
        val wordGroups = mutableMapOf<String, MutableList<String>>()
        for (i in 0 until quantity) {
            var word : String
            do {
                print("Слово ${i+1} = ")
                word = readln()

                val isWord = word.isNotEmpty() && !word.contains(' ')
                if (!isWord) {
                    println("Введите не пустое слово и без пробелов!")
                }
            } while (!isWord)
            words.add(word)

            val wordKey = word.toSortedSet().joinToString("")
            val wordGroup = wordGroups[wordKey]
            if (wordGroup != null) {
                wordGroup.add(word)
            } else {
                wordGroups[wordKey] = mutableListOf(word)
            }
        }

        for ((group, words) in wordGroups.entries) {
            println("Группа $group: ${words.joinToString()}")
        }

    } else {
        println("Некорректный ввод!")
    }
}