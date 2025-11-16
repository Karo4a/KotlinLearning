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

fun inputPoint2(pointName : String) : Point2 {
    println("Заполним точку $pointName:")
    return Point2(
        inputDouble("координату x"),
        inputDouble("координату y")
    )
}