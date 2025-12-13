package pizzeria_chain

import pizzeria_chain.classes.*

fun task1() {
    println("Сеть пиццерий.")

    val pizzeriaPeter = PizzeriaPeter(
        175.3, 241.5,
        167.5, 215.0
    )
    val pizzeriaMoscow = PizzeriaMoscow(
        215.3, 250.5,
        180.5, 240.0
    )

    while (true) {
        println("Добрый день! Выберите город:")
        println("1. Москва")
        println("2. Санкт-Петербург")
        println("0. Выход из программы")

        val currentPizzeriaCity = when (readln()) { // city
            "1" -> pizzeriaMoscow
            "2" -> pizzeriaPeter
            "0" -> break
            else -> {
                println("Неправильный выбор города!")
                continue
            }
        }

        selectPizza(currentPizzeriaCity)
    }
}

private fun selectPizza(currentPizzeriaCity: AbstractPizzeriaCity) {
    println("Выберите пиццу:")
    println("1. Неаполитанская пицца")
    println("2. Римская пицца")
    println("3. Сицилийская пицца")
    println("4. Тирольская пицца")
    println("0. Показать статистику")

    when (readln()) { // pizza
        "1" -> {
            currentPizzeriaCity.neapolitanPizzaSale()
            selectAddService(currentPizzeriaCity)
        }
        "2" -> {
            currentPizzeriaCity.romanPizzaSale()
            selectAddService(currentPizzeriaCity)
        }
        "3" -> {
            currentPizzeriaCity.sicilianPizzaSale()
            selectAddService(currentPizzeriaCity)
        }
        "4" -> {
            currentPizzeriaCity.tyroleanPizzaSale()
            selectAddService(currentPizzeriaCity)
        }
        "0" -> currentPizzeriaCity.showStatistics()
        else -> {
            println("Неправильный выбор пиццы!")
            return
        }
    }
}

private fun selectAddService(currentPizzeriaCity: AbstractPizzeriaCity) {
    when (currentPizzeriaCity) {
        is ICheckPhoto -> currentPizzeriaCity.showCheckPhoto()
        is IDrink -> currentPizzeriaCity.drinkSale()
    }
}