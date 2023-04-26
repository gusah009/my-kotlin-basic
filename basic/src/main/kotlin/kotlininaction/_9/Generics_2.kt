package kotlininaction._9

inline fun <reified T> isA(value: Any) = value is T

interface List<out E> : Collection<E> {
    override fun contains(element: @UnsafeVariance E): Boolean
    override fun iterator(): Iterator<E>
}

interface Comparator<in T> {
    fun compare(e1: T, e2: T): Int
}
