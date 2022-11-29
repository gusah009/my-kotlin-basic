package kotlininaction._2

fun main(args: Array<String>) {
    printName()
    classTest()
    iterTest()
}

fun iterTest() {
    for (c in 'a' downTo 'F') {
        println(c)
    }

    val list = arrayListOf(1, 4, 5, 11)
    for ((index, element) in list.withIndex()) {
        println("$index : $element")
    }
}

private fun classTest() {
    val person = Person("정현모", 25)
    println(person.isOld)
    println(person.isOldFunc())
    // person.name = "aa" // 컴파일 에러!
    person.age = 26 // 한 살 더 먹기!
    println(person.isOld)
    println(person.isOldFunc())
    println()
}

// 함수 선언을 fun으로 한다.
// 변수명 뒤에 변수 타입을 쓴다.
// return 타입은 인자를 넣는 곳 뒤에 쓴다. (void 라면 비워도 된다)
// Java와 달리 꼭 클래스 안에 함수를 넣을 필요가 없다.
// 세미콜론을 붙이지 않아도 된다.
fun test(args: Array<String>): String {
    println("Hello world!")
    return "Bye"
}

// 문자열 템플릿이 사용 가능하다.
// 한글을 문자열 템플릿에 사용할 땐 변수로
// 볼 수 있기 때문에 {} 중괄호를 붙여주는 것이 좋다.
val name = "현모"
val helloStr = "${name}님 반가와요."
fun printName() = println(helloStr)

class Person(
    val name: String,
    var age: Int
) {
    val isOld = age > 25
    fun isOldFunc() = age > 25
}