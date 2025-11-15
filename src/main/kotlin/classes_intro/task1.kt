package classes_intro

import kotlin.math.abs

class Point(val x : Double, val y : Double) {
    operator fun minus(point: Point): Point {
        return Point(x - point.x, y - point.y)
    }

    operator fun plus(point: Point): Point {
        return Point(x + point.x, y + point.y)
    }
}

class Triangle(
    private val point1 : Point,
    private val point2 : Point,
    private val point3 : Point
) {
    fun area() : Double {
        val vector21 = point2 - point1
        val vector31 = point3 - point1
        val cross = vector21.x * vector31.y - vector21.y * vector31.x
        return 0.5 * abs(cross)
    }

    fun isPointInTriangle(point : Point) : Boolean {
        val area = this.area()
        val pointArea1 = Triangle(point1, point2, point).area()
        val pointArea2 = Triangle(point1, point3, point).area()
        val pointArea3 = Triangle(point2, point3, point).area()
        return abs(area - (pointArea1 + pointArea2 + pointArea3)) < 1e-4
    }
}

fun inputPoint(pointName : String) : Point {
    return Point(0.0, 0.0)
}

fun task1() {
    val a = Point(2.0,3.0)
    val b = Point(5.0, 4.0)
    val c = Point(3.0, 7.5)
    val triangle = Triangle(a, b, c)

    val point = Point(4.0,4.0)
    println(triangle.isPointInTriangle(point))
}