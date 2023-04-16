package kotlininaction._8

fun main() {
    val result = calculator(1, 2) { x: Int, y: Int -> x + y }
    println(result) // 3

    calculator(1, 2) { x, y -> x + y }

    val calculator = getCostCalculator(Delivery.STANDARD)
    println(calculator(Order(3)))

    val avgDurationByWindows = log.filter { it.os == OS.WINDOWS }
        .map(SiteVisit::duration)
        .average()
    println(avgDurationByWindows)
    println(log.avgDurationBy(OS.WINDOWS))
}

inline fun calculator(x: Int, y: Int, operator: (Int, Int) -> Int): Int {
    println("Input: $x, $y")
    return operator(x, y)
}

class Order(val itemCount: Int)

fun getCostCalculator(delivery: Delivery): (Order) -> Double {
    return when (delivery) {
        Delivery.STANDARD -> { order -> 6 + 2.1 * order.itemCount }
        Delivery.EXPEDITED -> { order -> 1.2 * order.itemCount }
    }
}

enum class Delivery {
    STANDARD {
        override fun calculating(order: Order) = 6 + 2.1 * order.itemCount
    },
    EXPEDITED {
        override fun calculating(order: Order) = 1.2 * order.itemCount
    };

    abstract fun calculating(order: Order): Double
}

data class SiteVisit(
    val path: String,
    val duration: Double,
    val os: OS
)

enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

val log = listOf(
    SiteVisit("/", 34.0, OS.WINDOWS),
    SiteVisit("/", 22.0, OS.MAC),
    SiteVisit("/login", 12.0, OS.WINDOWS),
    SiteVisit("/signup", 8.0, OS.IOS),
    SiteVisit("/", 16.3, OS.ANDROID),
)

fun List<SiteVisit>.avgDurationBy(os: OS) =
    this.filter { it.os == os }
        .map(SiteVisit::duration)
        .average()
