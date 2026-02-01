package view

import domain.GameString

interface InputView {
    fun getInput(): GameString
}

class ConsoleInputView : InputView {
    override fun getInput(): GameString {
        while (true) {
            println("정답을 입력해주세요.")
            val inputWord = readLine()!!.trim()
            try {
                return GameString(inputWord)
            } catch (exception: Exception) {
                println(exception.message)
                continue
            }
        }
    }
}
