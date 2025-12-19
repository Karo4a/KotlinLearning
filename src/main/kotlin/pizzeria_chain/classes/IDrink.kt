package pizzeria_chain.classes

interface IDrink {
    val drinkSalePrice : Double
    var drinkSaleCount : MutableMap<String, Int>

    fun drinkSale(pizza: Pizza)
}