package pizzeria_chain.classes

class PizzeriaPeter (
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : AbstractPizzeriaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), IDrink {
    override val cityName = "Санкт-Петербург"

    override val drinkSalePrice = 200.0
    override var drinkSaleCount = 0

    override fun drinkSale() {
        println("Вы будете кофе?")
        println("1. Да")
        println("2. Нет")
        if (readln() == "1") {
            println("С вас $drinkSalePrice рублей")
            drinkSaleCount++
        }
    }

    override fun pizzaSale(pizza : Pizza) {
        super.pizzaSale(pizza)
        println("Спасибо за покупку пиццы: ${Pizzas.ruNameByPizza[pizza]}, в городе $cityName")
    }

    override fun showStatistics() {
        var money = 0.0
        for (pizza in Pizzas.list) {
            money += pizzasPrice[pizza.name]!! * pizzasCount[pizza.name]!!
            println("Продано пиццы: ${Pizzas.ruNameByPizza[pizza]} = ${pizzasCount[pizza.name]}")
        }

        money += drinkSaleCount * drinkSalePrice

        println("Всего заработано денег: $money")
    }
}