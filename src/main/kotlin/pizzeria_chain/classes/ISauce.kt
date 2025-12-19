package pizzeria_chain.classes

interface ISauce {
    val sauceSalePrice : Map<String, Double>
    var sauceSaleCount : MutableMap<String, Int>

    fun sauceSale(pizza: Pizza)
}