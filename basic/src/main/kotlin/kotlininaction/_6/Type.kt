package kotlininaction._6

fun strLenNotNull(s: String) = s.length
fun strLenNullable(s: String?) = if (s != null) s.length else 0
fun strLenCompact(s: String?) = s?.length ?: 0
fun doubleBang(s: String?) = s!!.length
