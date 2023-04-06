package kotlininaction._7

import java.time.LocalDate

operator fun Point.get(index: Int): Int {
    return when(index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException()
    }
}

operator fun Point.set(index: Int, value: Int){
    when(index) {
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException()
    }
}

fun main() {
    val now = LocalDate.now()
    println(now.plusWeeks(1) in now..now.plusDays(10)) // true
    println(Point(10, 20) != Point(20, 10))

    println("abc" < "abd")
    println(Point(10, 20) > Point(10, 15))

    val map = mapOf("현모" to 26, "효림" to 27, "성욱" to 28)
    println("${map["현모"]}, ${map["효림"]}, ${map["성욱"]}")
    println(Point(10, 20)[0])

    val p = Point(10, 20)
    p[0] = 30
    println(p[0]) // 30

    val rect = Rectangle(Point(10, 10), Point(30, 30))
    println(Point(20, 20) in rect)
    println(Point(30, 40) in rect)

    for ((key, value) in map) {
        println("$key -> $value")
    }
}

class Point(var x: Int, var y: Int) : Comparable<Point> {
    override fun compareTo(other: Point): Int {
        return compareValuesBy(this, other, Point::x, Point::y)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Point) return false
        return other.x == x && other.y == y
    }
}

data class Rectangle(val upperLeft: Point, val lowerRight: Point)

operator fun Rectangle.contains(p: Point): Boolean {
    return p.x in upperLeft.x until lowerRight.x &&
            p.y in upperLeft.y until lowerRight.y
}
