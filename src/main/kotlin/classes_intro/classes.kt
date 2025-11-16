package classes_intro

import kotlin.math.abs
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

data class Triangle(
    private val point1 : Point2,
    private val point2 : Point2,
    private val point3 : Point2
) {
    fun area() : Double {
        val vector21 = point2 - point1
        val vector31 = point3 - point1
        val cross = vector21.x * vector31.y - vector21.y * vector31.x
        return 0.5 * abs(cross)
    }

    fun isPointInTriangle(point : Point2) : Boolean {
        val area = this.area()
        val pointArea1 = Triangle(point1, point2, point).area()
        val pointArea2 = Triangle(point1, point3, point).area()
        val pointArea3 = Triangle(point2, point3, point).area()
        return abs(area - (pointArea1 + pointArea2 + pointArea3)) < 1e-4
    }
}