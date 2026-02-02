package view

import domain.GameString

interface InputView {
    fun getInput(): GameString
}

class ConsoleInputView : InputView {
    override fun getInput(): GameString {
        while (true) {
            println("정답을 입력해주세요.")
            try {
                val inputWord = readlnOrNull() ?: throw IllegalStateException("입력 되지 않았습니다")
                return GameString(inputWord)
            } catch (exception: Exception) {
                println(exception.message)
                continue
            }
        }
    }
}
