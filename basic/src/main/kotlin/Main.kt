fun main(args: Array<String>) {
    // 출력문 연습
    print("hello?")
    print("개행 안되나?\n")
    println("hoho")
    println("printf는 없네용")
    println(args.joinToString())

    println(sum(3, 5.5))
    println(sum(4, 2.2))
    println()

    val a: Byte = 1
    val b = 2.2
    val c: Double
    c = 4.5
    println("$a $b $c") // printf 대신 이게 되네요?
    println()

    // val은 const와 같음 한 번만 초기화 됨
    // var은 let과 같음. 여러번 갱신 가능
    var x = 1
    x++
    var y = 5.5
    y++ // Double형에 ++ 연산이 먹히넹
    println(y)
    println()

    val rectangle = Rectangle(5.0, 2.0)
    println("perimeter is ${rectangle.perimeter}")
    println()

    val square = Square(3.0)
    println("perimeter is ${square.perimeter}")
    println()

    // for enhance 사용 가능
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }
    println()

    println(describe(1))
    println(describe("Hello"))
    println(describe(3.3))
    println()

    // 범위 표현 가능
    val z = 5
    if (z in 1..10) {
        println("fits in range")
    }
    for (i in 1..5) {
        print("$i ")
    }
    println()
    println()

    // list 언어단에서 collections로 지원함
    val list = listOf("apple", "banana", "kiwifruit")
    for (item in list) {
        println(item)
    }
    if ("apple" in list) {
        println("거의 파이썬 쓰는 느낌")
    }
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }
    println()

    val arg1 = "a"
    val arg2 = "b"
    val intX = parseInt(arg1)
    val intY = parseInt(arg2)
    // x와 x의 값이 null 일 수 있기 때문에 사용하기 전에 null 체크를 해주어야 합니다.
    if (intX != null && intY != null) {
        // null체크가 끝난 이후에는 해당 변수들의 타입은 null이 아닌 원래의 타입으로 자동으로 변경됩니다.
        println(intX * intY)
    } else {
        println("'$arg1' or '$arg2' is not a number")
    }
    println()

    // is 연산자가 isInstance와 같음
    if (rectangle is Shape) {
        println("rectangle is Shape")
    }
    if (rectangle is Rectangle) {
        println("rectangle is Rectangle")
    }
    if (!(rectangle is Square)) {
        println("rectangle is Not Square")
    }
    println()
}

// 보통 function
fun sumFunc(a: Int, b: Double): Double {
    return a + b
}

// 타입 추론 return
fun sum(a: Int, b: Double) = a + b

// class 만들기
interface Shape

// 클래스 선언시 등록한 프로퍼티들은 자동으로 생성됨.
// 상속 시 open으로 열어줘야 함. 기본적으로 final로 막혀있음.
open class Rectangle(height: Double, length: Double) : Shape {
    val perimeter = (height + length) * 2
}

// 상속하기
class Square(oneSide: Double) : Rectangle(oneSide, oneSide)

fun maxOf(a: Int, b: Int) = if (a > b) a else b

// C의 Switch 같은 기능을 when이 사용함.
// @formatter:off
fun describe(obj: Any): String =
    when (obj) {
        1           -> "One"            // obj의 값이 1이라면 "One" 반환
        "Hello"     -> "Greeting"       // obj의 값이 Hello이라면 "Greeting" 반환
        is Long     -> "Long"           // obj이 Long타입이라면 "Long" 반환
        !is String  -> "Not a string"   // obj이 String타입이 아니라면 "Not a string" 반환
        else        -> "Unknown"        // 위 조건에 모두 해당되지 않는다면 "Unknown" 반환
    }
// @formatter:on

// Nullable 체크를 Optional 안쓰고 언어단에서 지원
fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}