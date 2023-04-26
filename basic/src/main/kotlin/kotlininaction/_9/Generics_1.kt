package kotlininaction._9


//val people = listOf("현모", "창율", "승현")
val people = listOf<String>("현모", "창율", "승현")

fun main() {
    listOf(1, 2, 3).sum()
    printSum(listOf(1, 2, 3))
    printSum(listOf("1", "2", "3"))
}

interface MyList<T> {
    operator fun get(index: Int): T
}

class StringList : MyList<String> {
    override fun get(index: Int): String = TODO()
}

class ArrayList<T> : MyList<T> {
    override fun get(index: Int): T = TODO()
}

fun printSum(c: Collection<*>) {
    val intList = c as List<Int>
    println(intList.sum())
}
