package basics

fun task1() {
    println("Программа подсчитывает количество подряд идущих одинаковых символов во введенной строке.")
    print("Введите строку: ")
    val input = readln()
    var result = String()
    var mainIndex = 0

    while (mainIndex < input.length) {
        val mainChar = input[mainIndex]
        var stepIndex = mainIndex + 1
        var counter = 1

        while (stepIndex <= input.lastIndex && input[stepIndex] == mainChar) {
            ++counter
            ++stepIndex
        }

        result += "$mainChar"
        mainIndex += counter
        if (counter > 1) {
            result += "$counter"
        }
    }
    println("Результат: $result")
}