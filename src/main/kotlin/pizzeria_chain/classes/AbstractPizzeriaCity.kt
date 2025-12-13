package pizzeria_chain.classes

abstract class AbstractPizzeriaCity (
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) {
    var pizzeriaCustomerCount = 0

    var pizzasPrice = mapOf(
        Pizzas.Neapolitan.name to neapolitanPizzaPrice,
        Pizzas.Roman.name to romanPizzaPrice,
        Pizzas.Sicilian.name to sicilianPizzaPrice,
        Pizzas.Tyrolean.name to tyroleanPizzaPrice,
    )

    var pizzasCount = mapOf(
        Pizzas.Neapolitan.name to 0,
        Pizzas.Roman.name to 0,
        Pizzas.Sicilian.name to 0,
        Pizzas.Tyrolean.name to 0,
    )

    protected abstract val cityName : String

    open fun pizzaSale(pizza: Pizza) {
        pizzasCount[pizza.name]?.inc()
    }

    abstract fun showStatistics()
}