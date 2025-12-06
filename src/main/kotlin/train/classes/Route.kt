package train.classes

import kotlin.random.Random

data class Route(
    val fromCity : City,
    val toCity : City
) {
    companion object {
        fun random(cities : List<City>) : Route {
            val fromCity = cities[Random.Default.nextInt(0, cities.size)]
            var toCity : City
            do {
                toCity = cities[Random.Default.nextInt(0, cities.size)]
            } while (fromCity == toCity)
            return Route(fromCity, toCity)
        }
    }

    fun info() : String {
        return "${fromCity.name} -> ${toCity.name}"
    }
}