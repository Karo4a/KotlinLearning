package pizzeria_chain.classes

class Pizzas {
    companion object {
        val Neapolitan = Pizza("neapolitan", 1)
        val Roman = Pizza("roman", 2)
        val Sicilian = Pizza("sicilian", 3)
        val Tyrolean = Pizza("tyrolean", 4)

        val list = listOf(Neapolitan, Roman, Sicilian, Tyrolean)

        val byIndex = list.associateBy { pizza -> pizza.index }
        val byName = list.associateBy { pizza -> pizza.name }

        val ruNameByPizza = mapOf(
            Neapolitan to "Неаполитанская",
            Roman to "Римская",
            Sicilian to "Сицилийская",
            Tyrolean to "Тирольская",
        )
    }
}