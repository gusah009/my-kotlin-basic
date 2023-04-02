package kotlininaction._5

fun main() {
    val doPlay = DoPlay()
    doPlay.printPlay(object : PersonInterface {
        override fun playWhatToDo() = "저는 게임을 하면서 놉니다."
    })
//    doPlay.printPlay { "저는 게임을 하면서 놉니다" } // 이게 왜 안되지??
    doPlay.printPlay(PlayPerson())
    doPlay.printPlay { "코틀린에선 이렇게 해야 되네" }
}

class DoPlay {
    fun printPlay(person: PersonInterface) {
        println(person.playWhatToDo())
    }

    fun printPlay(whatTodo: () -> String) {
        println(run(whatTodo))
    }
}

@FunctionalInterface
interface PersonInterface {
    fun playWhatToDo(): String
}

class PlayPerson : PersonInterface {
    override fun playWhatToDo() = "음악 듣기"
}