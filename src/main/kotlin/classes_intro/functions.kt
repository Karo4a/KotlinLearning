package classes_intro

fun inputDouble(inputName : String) : Double {
    var num : Double?
    do {
        print("Введите $inputName: ")
        num = readln().toDoubleOrNull()

        if (num == null) {
            println("Неправильно! Введите вещественное число.\n")
        }
    } while(num == null)
    return num
}

fun inputPoint(pointName : String) : Point {
    println("Заполним точку $pointName:")
    return Point(
        inputDouble("координату x"),
        inputDouble("координату y")
    )
}