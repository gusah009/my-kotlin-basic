package kotlininaction._4

fun main() {
    val clazz = Class()
    clazz.click()
    clazz.showOff()
    println(clazz.SOME_CONST)
    println()

    val button = Button()
    println(button.state.clicked)
    button.clicked()
    println(button.state.clicked)
    button.clicked()
    println(button.state.clicked)
    println()

    println(calculate(Expr.Add(5, 3)))
    println(calculate(Expr.Sub(5, 3)))
    println()

    // default 파라미터가 모든 파라미터에 있을 경우 파라미터가 없는 생성자를 만들어 주기 때문에 컴파일 에러 안남!
    val constructorTest = ConstructorTest()

    println(DataClass("현모", 25) == DataClass("현모", 25))
    println(DataClass("현모", 25) === DataClass("현모", 25))
    println(DataClass("현모", 25) == DataClass("길동", 25))
    println(DataClass("현모", 25).copy(age = 26)) // 나이를 먹었다!
    println()
}

// 코틀린 인터페이스 알아보기
interface Clickable {
    fun click()
    fun showOff() = println("I'm Clickable!") // 디폴트 구현을 할 때 default를 써 줄 필요가 없다.
}

interface Focusable {
    val SOME_CONST: String
        get() = "안녕하세요" // 하지만 상수는 가질 수 있다.
    // set(value) = field = value // 코틀린에서 field를 쓸 수 없음은 인터페이스가 상태를 가지지 못한다는 뜻이다.

    fun showOff() = println("I'm Focusable")
}

class Class : Clickable, Focusable {
    override val SOME_CONST: String
        get() = "안녕히 가세요" // 상수를 오버라이드 하는 것 또한 가능하다.

    override fun click() = println("클릭!") // 코틀린은 자바와 다르게 반드시 override를 붙여야 한다.

    override fun showOff() { // default 메서드가 겹친다면 override 해줘야 한다. 안그럼 에러남.
        super<Clickable>.showOff() // <>를 이용해 어떤 인터페이스의 showOff() 메서드를 불러올 지 결정 가능
        super<Focusable>.showOff()
    }
}

class Super { // 상속할 수 없다!
}

//class Sub : Super { } // 기본적으로 kotlin은 클래스가 final이다.

open class OpenSuper {
    fun notOverride() {}
    open fun canOverride() {}
}

open class OpenSub : OpenSuper() {
    // final을 붙여줌으로써 더이상 override가 안되게 막음
    final override fun canOverride() = println("이젠 아니야...")
}

class GrandSub : OpenSub() {
//    override fun canOverride() {} // 상속 이제 안됨
}

// 접근 제어자 (가시성 변경자)
internal open class TalkativeButton : Focusable {
    internal fun hi() = println("Hi!")
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

/*
// internal 클래스에 public function이 들어갈 수 없다.
fun TalkativeButton.giveSpeech() {
    yell() // private 멤버
    whisper() // protected 멤버
}
*/

// 같거나 더 낮은 수준의 접근제어자라면 사용이 가능하다.
internal fun TalkativeButton.giveSpeech() {
    hi()
}

// 중첩클래스
class Button {
    var state: State = State(false)

    fun clicked() {
        state = State(!state.clicked)
    }

    // 기본적으로 static class 이다.
    class State(val clicked: Boolean) {
    }
}

// Sealed Class
sealed class Expr {
    class Add(val value1: Int, val value2: Int) : Expr()
    class Sub(val value1: Int, val value2: Int) : Expr()
}

fun calculate(e: Expr): Int = when (e) {
    is Expr.Add -> e.value1 + e.value2
    is Expr.Sub -> e.value1 - e.value2
}

// 클래스의 생성자
class ConstructorTest(
    val value1: Int = 1,
    val value2: Int = 2
)

// data 클래스
data class DataClass(
    val name: String,
    val age: Int
) // toString, equals, hashCode를 모두 만들어준다.
