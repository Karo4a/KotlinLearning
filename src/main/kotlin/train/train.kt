package train

import kotlin.random.Random
import kotlin.random.nextUInt

private val cities = City.listOf(
    "Москва",
    "Санкт-Петербург",
    "Новосибирск",
    "Екатеринбург",
    "Казань",
    "Нижний Новгород",
    "Челябинск",
    "Самара",
    "Омск",
    "Ростов-на-Дону",
    "Уфа",
    "Красноярск",
    "Воронеж",
    "Пермь",
    "Краснодар"
)

private const val minPassegers = 5U
private const val maxPassegers = 201U

private const val minCarriageCapacity = 5U
private const val maxCarriageCapacity = 25U

data class City(val name : String) {
    companion object {
        fun listOf(vararg names: String) : List<City> {
            return names.map { City(it) }.toList()
        }
    }
}

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
            } while (fromCity != toCity)
            return Route(fromCity, toCity)
        }
    }
}

class Carriage {
    var route = Route.random(cities)
    val capacity = Random.Default.nextUInt(minCarriageCapacity, maxCarriageCapacity.inc())
    var occupied = 0U

    fun occupy(seats : UInt) : UInt? {
        var excess : UInt? = null
        occupied = if (seats >= capacity) {
            excess = capacity - seats
            capacity
        } else if (seats < 0U) {
            0U
        } else {
            seats
        }
        return excess
    }
}

class Train {
    val passengers = Random.Default.nextUInt(minPassegers, maxPassegers.inc())
}