package kotlininaction._5

/**
 * 람다 식과 멤버 참조
 */
fun main() {
    val people = listOf(Person("현모", 25), Person("재욱재욱", 25), Person("레전드", 26))
    val minAgePerson = people.minBy { it.age } // it를 사용해 쉽게 접근이 가능하다.
    println(minAgePerson)
    println(people.maxBy(Person::age)) // 멤버 참조
    println(people.joinToString { it.name }) // 파라미터 마지막에 람다가 들어온다면 맨 뒤에 {}로 인자를 넣을 수 있다.
    println()

    happyNewYear(people)
}

data class Person(val name: String, var age: Int) {
    fun happyNewYear() = Person(name, age + 1)
}

fun happyNewYear(people: List<Person>) {
    var oldMan = 0
    people.forEach {
        println("happy new year! ${it.name}'s age changed: ${it.age} -> ${it.age + 1}")
        it.age++
        if (it.age > 25) oldMan++ // 람다 안에서 final이 아닌 바깥 변수를 수정할 수 있다!
    }
    println("old man count: ${oldMan}")
}