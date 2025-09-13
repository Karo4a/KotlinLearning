package arrays

fun task1() {
    println("Ручной ввод чисел в матрицу!")

    print("Количество строк в матрице: ")
    val sizeRows = readln().toUIntOrNull()
    if (sizeRows != null) {
        print("Количество столбец в матрице: ")
        val sizeCols = readln().toUIntOrNull()
        if (sizeCols != null) {
            println("Вводите только трехзначные числа!")
            val matrix = arrayOfNulls<Array<Int>>(sizeRows.toInt())
            for (i in 0..sizeRows.toInt()) {

            }

        } else {
            println("Некорректный ввод количества столбцов!")
        }
    } else {
        println("Некорректный ввод количества строк!")
    }
}