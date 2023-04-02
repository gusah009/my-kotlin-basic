package kotlininaction._5

/**
 * 컬렉션 함수형 API
 */
fun main() {
    val books = listOf(
        Book("책A", listOf("저자1")),
        Book("책B", listOf("저자1", "저자2")),
        Book("책C", listOf("저자1", "저자3")),
        Book("책D", listOf("저자4"))
    )
    println(books.map(Book::name))
    println(books.filter { it.authors.contains("저자1") })
    println(books.filter { it.authors.contains("저자1") }.map(Book::name))
    println(books.flatMap(Book::authors).toSet())
}

data class Book(val name: String, val authors: List<String>)