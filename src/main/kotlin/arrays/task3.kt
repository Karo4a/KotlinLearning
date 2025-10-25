package arrays

import kotlin.math.ceil

val russianAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯ".map{ it }.toTypedArray()
val codeAlphabet = arrayOf(21, 13, 4, 20, 22, 1, 25, 12, 24, 14, 2, 28, 9, 23, 3, 29, 6, 16, 15, 11, 26, 5, 30, 27, 8, 18, 10, 33, 31, 32, 19, 7, 17)

var toCode : Map<Char, Int> = russianAlphabet.zip(codeAlphabet).toMap()
var toRus = codeAlphabet.zip(russianAlphabet).toMap()

fun task3() {
    println("Программа шифрует или дешифрует введенное слово по заданному ключевому слову.")

    println("Зашифровать или расшифровать текст?")
    println("1 - Зашифровать")
    println("2 - Расшифровать")
    print("Выбор: ")

    val choice = readln().toIntOrNull()

    if (choice  !in 1..2) {
        println("Некорректный выбор!")
        return
    }

    print("Введите ключевое слово: ")
    val keyWord = readln()

    if (choice == 1) {
        print("Введите слово для зашифрования: ")
    } else if (choice == 2) {
        print("Введите слово для расшифрования: ")
    }
    val inputWord = readln().uppercase()

    if (choice == 1) {
        encode(inputWord, keyWord)
    } else if (choice == 2) {
        decode(inputWord, keyWord)
    }
}

fun encode(word : String, keyWord : String) {
    val repeats = ceil(word.length.toFloat() / keyWord.length.toFloat()).toInt()
    val preparedKeyWord = keyWord.repeat(repeats).slice(0..word.lastIndex).uppercase()

    val processedSymbols = mutableListOf<Char>()
    var isProcessed = true
    for ((wordChar, keyChar) in word.zip(preparedKeyWord)) {
        val keyCode = toCode[keyChar]
        if (keyCode != null) {
            val inputWordCode = toCode[wordChar]
            if (inputWordCode != null) {
                val encodedChar = toRus[(keyCode + inputWordCode - 1) % 33 + 1]
                if (encodedChar != null) {
                    processedSymbols.add(encodedChar)
                }
            } else {
                println("Введенное слово содержит недопустимые символы (только русский алфавит)!")
                isProcessed = false
                break
            }
        } else {
            println("Ключевое слово содержит недопустимые символы (только русский алфавит)!")
            isProcessed = false
            break
        }
    }

    if (isProcessed) {
        val encodedWord = processedSymbols.joinToString("")
        println("Зашифрованное слово: $encodedWord")
    }
}

fun decode(word : String, keyWord : String) {
    val repeats = ceil(word.length.toFloat() / keyWord.length.toFloat()).toInt()
    val preparedKeyWord = keyWord.repeat(repeats).slice(0..word.lastIndex).uppercase()

    val processedSymbols = mutableListOf<Char>()
    var isProcessed = true
    for ((wordChar, keyChar) in word.zip(preparedKeyWord)) {
        val keyCode = toCode[keyChar]
        if (keyCode != null) {
            val inputWordCode = toCode[wordChar]
            if (inputWordCode != null) {
                var decodedCode = inputWordCode - keyCode
                if (decodedCode < 1) {
                    decodedCode += 33
                }
                val decodedChar = toRus[decodedCode]
                if (decodedChar != null) {
                    processedSymbols.add(decodedChar)
                }
            } else {
                println("Введенное слово содержит недопустимые символы (только русский алфавит)!")
                isProcessed = false
                break
            }
        } else {
            println("Ключевое слово содержит недопустимые символы (только русский алфавит)!")
            isProcessed = false
            break
        }
    }

    if (isProcessed) {
        val encodedWord = processedSymbols.joinToString("")
        println("Дешифрованное слово: $encodedWord")
    }
}