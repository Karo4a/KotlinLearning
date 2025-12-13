package pizzeria_chain.classes

interface IDrink {
    val drinkSalePrice : Double
    var drinkSaleCount : Int

    fun drinkSale()
}