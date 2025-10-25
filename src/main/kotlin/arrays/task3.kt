package arrays

fun task3() {
    val russianAlphabet = 'А'..'Я'
    val codeAlphabet = 1..33

    val codeShuffled = codeAlphabet.shuffled()
    var toCode = russianAlphabet.zip(codeShuffled).toMap()
    var toRus = codeShuffled.zip(russianAlphabet).toMap()

    println("Программа шифрует или дешифрует введенное слово по заданному ключевому слову.")

    var keyWord = "ПОЛЕ"
    var inputWord = ""
}