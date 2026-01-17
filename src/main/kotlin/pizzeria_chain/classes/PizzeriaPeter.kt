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
    override var drinkSaleCount = mapOf(
        Pizzas.Neapolitan.name to 0,
        Pizzas.Roman.name to 0,
        Pizzas.Sicilian.name to 0,
        Pizzas.Tyrolean.name to 0,
    ).toMutableMap()

    override fun drinkSale(pizza: Pizza) {
        println("Вы будете кофе?")
        println("1. Да")
        println("2. Нет")
        if (readln() == "1") {
            println("С вас $drinkSalePrice рублей")
            val current = drinkSaleCount.getOrDefault(pizza.name, 0)
            drinkSaleCount[pizza.name] = current + 1
        }
    }

    override fun pizzaSale(pizza : Pizza) {
        super.pizzaSale(pizza)
        println("Спасибо за покупку пиццы: ${Pizzas.ruNameByPizza[pizza]}, - в городе $cityName")
    }

    override fun showStatistics() {
        var money = 0.0
        for (pizza in Pizzas.list) {
            money += pizzasPrice[pizza.name]!! * pizzasCount[pizza.name]!!
            println("Продано пиццы: ${Pizzas.ruNameByPizza[pizza]} = ${pizzasCount[pizza.name]}")
        }

        val soldDrinksCount = drinkSaleCount.values.sum()
        val moneyFromDrink = soldDrinksCount * drinkSalePrice
        money += moneyFromDrink

        println("Заработано денег с напитков: $moneyFromDrink")
        println("Всего заработано денег: $money")
        if (pizzeriaCustomerCount > 0) {
            println("${soldDrinksCount*100/pizzeriaCustomerCount}% людей покупают напитки.")
        }
        if (soldDrinksCount > 0) {
            val maxPizzasDrinksBuy = drinkSaleCount.maxBy {it.value}
            println("К пицце: ${Pizzas.ruNameByPizza[Pizzas.byName[maxPizzasDrinksBuy.key]]}, - купили больше всего напитков.")
            println("А именно - ${maxPizzasDrinksBuy.value}, что составляет ${maxPizzasDrinksBuy.value*100/soldDrinksCount}% от всех проданных напитков к пиццам.")
        }
        println()
    }
}