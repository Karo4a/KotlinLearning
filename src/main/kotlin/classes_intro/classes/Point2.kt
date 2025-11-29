package classes_intro.classes

import kotlin.math.pow
import kotlin.math.sqrt

data class Point2(val x : Double, val y : Double) {
    operator fun minus(point: Point2) : Point2 {
        return Point2(x - point.x, y - point.y)
    }

    operator fun plus(point: Point2) : Point2 {
        return Point2(x + point.x, y + point.y)
    }

    companion object {
        fun length(point1 : Point2, point2 : Point2) : Double {
            val vector = point2 - point1
            return sqrt(vector.x.pow(2) + vector.y.pow(2))
        }
    }
}