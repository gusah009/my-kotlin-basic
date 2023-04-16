package kotlininaction._8

fun main() {
    lambdaReturn()
    labelReturn()
    anonymousFunc()
}

fun lambdaReturn() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) {
            return
        }
    }
    println("Not print !!!") // 호출되지 않는다.
}

fun labelReturn() {
    listOf(1, 2, 3, 4, 5).myForEach hyeonmo@{
        if (it == 3) return@hyeonmo
    }
    println("print !!!") // 호출된다.
    listOf(1, 2, 3, 4, 5).myForEach {
        if (it == 3) return@myForEach
    }
    println("print !!!") // 호출된다.
}

fun anonymousFunc() {
    listOf(1, 2, 3, 4, 5).forEach(fun(number) {
        if (number == 3) return
    })
    println("print !!!") // 호출된다.
}

fun <T> Iterable<T>.myForEach(action: (T) -> Unit) {
    for (element in this) action(element)
}
