package kotlininaction._3

fun main() {
    extendFucntionProperty()
    spreadTest()
    destructuringAssignment()
    localFunc()
}

private fun localFunc() {
    saveUser(User(1, "gusah009", "address"))
    localSaveUser(User(1, "local009", "address"))
    extensionSaveUser(User(1, "extension009", "address"))
    println()
}

private fun extendFucntionProperty() {
    "abcefgh".printByStep(2)
    println(27593.lastDigit)
    val str = StringBuilder("abcdef")
    str.lastChar = 'h'
    println(str)
}

// String 확장함수 사용해보기
fun String.printByStep(step: Int) {
    for (index in 0..this.length step step)
        print(this[index])
    println()
    println()
}

// 확장 프로퍼티는 간단하게 val이면 getter var이면 getter, setter를 추가해주면 된다.
val Int.lastDigit: Int
    get() = this % 10

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) {
        this.setCharAt(length - 1, value)
    }

// spread(*) 사용
fun spreadTest() {
    val a = "A";
    val bcd = arrayOf("B", "C", "D");
    val e = "E";
    val fghi = arrayOf("F", "G", "H", "I")
    println(join(a, *bcd, e, *fghi))
    println()
}

fun join(vararg e: String): String {
    val sb = StringBuilder();
    for (s in e) {
        sb.append(s)
        sb.append(" ")
    }
    sb.trim()
    return sb.toString()
}

// 구조 분해 할당
fun destructuringAssignment() {
    val pair = Pair("A", 3)
    val (first, second) = pair
    println("$first $second")

    val poker = mapOf(
        "Jack" to 11,
        "Queen" to 12,
        "King" to 13,
        "Ace" to 14
    )
    for ((name, number) in poker) {
        println("$name: $number")
    }
    println()
}

// 로컬함수와 확장
class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    fun validate(
        user: User,
        value: String,
        fieldName: String
    ) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty $fieldName"
            )
        }
    }

    validate(user, user.name, "Name")
    validate(user, user.name, "Address")
    println("save user: [${user.name}] is complete!")
}

// 로컬 함수에선 바깥 함수의 인자를 사용할 수 있다.
fun localSaveUser(user: User) {
    fun validate(
        value: String,
        fieldName: String
    ) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty $fieldName"
            )
        }
    }

    validate(user.name, "Name")
    validate(user.name, "Address")
    println("save user: [${user.name}] is complete!")
}

// 확장함수 사용하기
// 이렇게 확장함수로 빼내면 User 클래스에선 validate하는 로직을 몰라도 되고,
// User 클래스를 더럽히지 않으면서 public property나 method에 접근할 수 있다.
fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${id}: empty $fieldName"
            )
        }
    }

    validate(name, "Name")
    validate(name, "Address")
}

fun extensionSaveUser(user: User) {
    user.validateBeforeSave()
    println("save user: [${user.name}] is complete!")
}