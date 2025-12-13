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

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в городе $cityName")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в $cityName")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в $cityName")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в $cityName")
    }

    override fun showStatistics() {
        println("Продано сицилийской пиццы: $sicilianPizzaCount")
        println("Продано неаполитанской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано тирольской пиццы: $tyroleanPizzaCount")

        val money = neapolitanPizzaCount * neapolitanPizzaPrice
            + romanPizzaCount * romanPizzaPrice
            + sicilianPizzaCount * sicilianPizzaPrice
            + tyroleanPizzaCount * tyroleanPizzaPrice
            + drinkSaleCount * drinkSalePrice

        println("Всего заработано денег: $money")
    }
}