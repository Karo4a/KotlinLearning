package classes_intro.classes

import kotlin.math.abs

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