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

        val discount = checkPhotoCount * checkPhotoDiscount
        val money = neapolitanPizzaCount * neapolitanPizzaPrice
            + romanPizzaCount * romanPizzaPrice
            + sicilianPizzaCount * sicilianPizzaPrice
            + tyroleanPizzaCount * tyroleanPizzaPrice - discount

        print("Скидка $discount")
        println("Всего заработано денег: $money")
    }
}