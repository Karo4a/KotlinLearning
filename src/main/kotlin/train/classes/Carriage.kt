package train.classes

import train.common.MIN_CARRIAGE_CAPACITY
import train.common.MAX_CARRIAGE_CAPACITY
import kotlin.random.Random
import kotlin.random.nextUInt

class Carriage {
    val capacity = Random.Default.nextUInt(MIN_CARRIAGE_CAPACITY, MAX_CARRIAGE_CAPACITY.inc())
    private var occupied = 0U

    fun occupy(seats: UInt): UInt? {
        var excess: UInt? = null
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

    fun info(): String {
        return "Пассажиры: $occupied/$capacity чел."
    }
}