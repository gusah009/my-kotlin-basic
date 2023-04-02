package kotlininaction._5

/**
 * 컬렉션 함수형 API
 */
fun main() {
    val people = listOf(Person("레전드", 22), Person("현모", 25), Person("재욱재욱", 23))
    people.filter { it.age > 25 }
        .map(Person::name) // 즉시 로딩!
    people.asSequence()
        .filter { it.age > 25 }
        .map(Person::name)
        .toList() // 지연 로딩! 지연로딩 후에는 다시 컬렉션으로 만들어준다!

    val hasOldMan = generateSequence(people) { it }
        .any {
            it.map(Person::happyNewYear)
                .any { person ->
                    println("check ${person.name}'s age... : ${person.age}")
                    person.age > 25
                }
        }

    when (hasOldMan) {
        true -> println("this group has old man")
        false -> println("this group is newbie")
    }
    println()

    when (people.hasOldMan()) {
        true -> println("this group has old man")
        false -> println("this group is newbie")
    }
}

fun List<Person>.hasOldMan() = this.asSequence()
    .map(Person::happyNewYear)
    .any { person ->
        println("check ${person.name}'s age... : ${person.age}")
        person.age > 25
    }
