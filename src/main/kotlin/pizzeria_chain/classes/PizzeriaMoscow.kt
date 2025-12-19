package pizzeria_chain.classes

class PizzeriaMoscow (
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : AbstractPizzeriaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), ICheckPhoto {
    override val cityName = "Москва"

    override val checkPhotoDiscount = 50.0
    override var checkPhotoCount = 0

    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1. Да")
        println("2. Нет")
        if (readln() == "1") {
            println("Вам будет скидка $checkPhotoDiscount рублей с покупки")
            checkPhotoCount++
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

        val discount = checkPhotoCount * checkPhotoDiscount
        money -= discount

        println("Скидка: $discount")
        println("Всего заработано денег: $money")
        if (pizzeriaCustomerCount > 0) {
            println("${checkPhotoCount/pizzeriaCustomerCount}% людей показывают фотографию чека.")
        }
        println()
    }
}