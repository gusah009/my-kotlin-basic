package kotlininaction._7

operator fun Point1.minus(other: Point1) = Point1(x - other.x, y - other.y)
operator fun Point1.rem(other: Point1) = Point1(x % other.x, y % other.y)

data class Point1(var x: Int, var y: Int) {

    operator fun plus(other: Point1) = Point1(x + other.x, y + other.y)
}

operator fun Point1.times(other: Double) = Point1((x * other).toInt(), (y * other).toInt())
operator fun Double.times(p: Point1) = Point1((this + p.x).toInt(), (this + p.y).toInt())

fun main() {
    val point1 = Point1(1, 2)
    val point2 = Point1(2, 5)
    println(point1 + point2)
    println(point1 - point2)
    println(1.5 * point1)
    println(point1 * 1.5)

    val arrayList = arrayListOf<Int>()
    arrayList += 13 // array 는 원소 추가가 가능하다
    println(arrayList[0])
    val list = listOf(1, 2, 3)
    val newList = list + arrayList // 복사본 반환!
    arrayList += 22
    println(arrayList)
    println(list)
    println(newList)


}
