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

        val soldPizza = salePizza(currentPizzeriaCity)
        if (soldPizza != null) {
            selectAddService(currentPizzeriaCity, soldPizza)
        }
    }
}

private fun salePizza(currentPizzeriaCity: AbstractPizzeriaCity) : Pizza? {
    println("Выберите пиццу:")
    println("1. Неаполитанская пицца")
    println("2. Римская пицца")
    println("3. Сицилийская пицца")
    println("4. Тирольская пицца")
    println("0. Показать статистику")

    val choice = readln()
    val pizza = Pizzas.byIndex[choice.toIntOrNull()]
    if (pizza != null) {
        currentPizzeriaCity.pizzaSale(pizza)
        return pizza
    }

    if (choice == "0") {
        currentPizzeriaCity.showStatistics()
    }
    return null
}

private fun selectAddService(currentPizzeriaCity: AbstractPizzeriaCity, pizza: Pizza) {
    if (currentPizzeriaCity is ICheckPhoto) {
        currentPizzeriaCity.showCheckPhoto()
    }
    if (currentPizzeriaCity is IDrink) {
        currentPizzeriaCity.drinkSale(pizza)
    }
}