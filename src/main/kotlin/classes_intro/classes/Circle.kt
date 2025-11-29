package classes_intro.classes

import kotlin.math.pow

data class Circle(
    val center : Point2,
    val radius : Double
) {
    companion object {
        fun circumcircle(triangle: Triangle): Circle? {
            val vertexA = triangle.point1
            val vertexB = triangle.point2
            val vertexC = triangle.point3

            val lengthAB = Point2.length(vertexA, vertexB) // c
            val lengthBC = Point2.length(vertexB, vertexC) // a
            val lengthCA = Point2.length(vertexC, vertexA) // b
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

        fun incircle(triangle: Triangle): Circle? {
            val area = triangle.area()
            if (area > 0) {
                val vertexA = triangle.point1
                val vertexB = triangle.point2
                val vertexC = triangle.point3

                val lengthAB = Point2.length(vertexA, vertexB) // c
                val lengthBC = Point2.length(vertexB, vertexC) // a
                val lengthCA = Point2.length(vertexC, vertexA) // b
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