package train

import kotlin.math.min
import kotlin.random.Random
import kotlin.random.nextUInt

private val CITIES = City.listOf(
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

private const val MIN_PASSENGERS = 5U
private const val MAX_PASSENGERS = 201U

private const val MIN_CARRIAGE_CAPACITY = 5U
private const val MAX_CARRIAGE_CAPACITY = 25U

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
            } while (fromCity == toCity)
            return Route(fromCity, toCity)
        }
    }

    fun info() : String {
        return "${fromCity.name} -> ${toCity.name}"
    }
}

class Carriage {
    val capacity = Random.Default.nextUInt(MIN_CARRIAGE_CAPACITY, MAX_CARRIAGE_CAPACITY.inc())
    private var occupied = 0U

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

    fun info() : String {
        return "Пассажиры: $occupied/$capacity чел."
    }
}

class Train {
    val route = Route.random(CITIES)
    val passengers = Random.Default.nextUInt(MIN_PASSENGERS, MAX_PASSENGERS.inc())
    val carriages = emptyList<Carriage>().toMutableList()

    init {
        fillTrain()
    }

    private fun fillTrain() {
        var passengersLeft = passengers
        while (passengersLeft > 0U) {
            val carriage = Carriage()
            val passengersOccupy = min(passengersLeft, carriage.capacity)
            passengersLeft -= passengersOccupy
            carriage.occupy(passengersOccupy)
            carriages.add(carriage)
        }
    }
}