package train.classes

import train.common.CITIES
import train.common.MIN_PASSENGERS
import train.common.MAX_PASSENGERS
import kotlin.math.min
import kotlin.random.Random
import kotlin.random.nextUInt

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