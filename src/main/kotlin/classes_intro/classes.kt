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
    val point1 : Point2,
    val point2 : Point2,
    val point3 : Point2
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

data class Circle(
    val center : Point2,
    val radius : Double
) {
    companion object {
        fun circumcircle(triangle : Triangle) : Circle? {
            val vertexA = triangle.point1
            val vertexB = triangle.point2
            val vertexC = triangle.point3

            val lengthAB  = Point2.length(vertexA, vertexB) // c
            val lengthBC  = Point2.length(vertexB, vertexC) // a
            val lengthCA  = Point2.length(vertexC, vertexA) // b
            // https://ru.wikipedia.org/wiki/Описанная_окружность#Декартовы_координаты_центра
            val d = 2 * (vertexA.x * (vertexB.y - vertexC.y)
                    + vertexB.x * (vertexC.y - vertexA.y)
                    + vertexC.x * (vertexA.y - vertexB.y))

            if (d != 0.0) {
                val centerX = ((vertexA.x.pow(2) + vertexA.y.pow(2)) * (vertexB.y - vertexC.y)
                        + (vertexB.x.pow(2) + vertexB.y.pow(2)) * (vertexC.y - vertexA.y)
                        + (vertexC.x.pow(2) + vertexC.y.pow(2)) * (vertexA.y - vertexB.y)) / d
                val centerY = ((vertexA.x.pow(2) + vertexA.y.pow(2)) * (vertexC.x - vertexB.x)
                        + (vertexB.x.pow(2) + vertexB.y.pow(2)) * (vertexA.x - vertexC.x)
                        + (vertexC.x.pow(2) + vertexC.y.pow(2)) * (vertexB.x - vertexA.x)) / d
                val centerPoint = Point2(centerX, centerY)
                // https://ru.wikipedia.org/wiki/Описанная_окружность#Радиус
                val radius = (lengthAB * lengthBC * lengthCA) / (4 * triangle.area())

                return Circle(centerPoint, radius)
            }
            return null
        }

        fun incircle(triangle : Triangle) : Circle? {
            val area = triangle.area()
            if (area > 0) {
                val vertexA = triangle.point1
                val vertexB = triangle.point2
                val vertexC = triangle.point3

                val lengthAB  = Point2.length(vertexA, vertexB) // c
                val lengthBC  = Point2.length(vertexB, vertexC) // a
                val lengthCA  = Point2.length(vertexC, vertexA) // b
                val perimeter = lengthAB + lengthBC + lengthCA

                // https://mathworld.wolfram.com/Incenter.html
                val centerX = ((lengthBC * vertexA.x + lengthCA * vertexB.x + lengthAB * vertexC.x)
                        / perimeter)
                val centerY = ((lengthBC * vertexA.y + lengthCA * vertexB.y + lengthAB * vertexC.y)
                        / perimeter)
                val centerPoint = Point2(centerX, centerY)
                // https://mathworld.wolfram.com/Inradius.html
                val radius = area / (perimeter / 2)

                return Circle(centerPoint, radius)
            }
            return null
        }
    }
}