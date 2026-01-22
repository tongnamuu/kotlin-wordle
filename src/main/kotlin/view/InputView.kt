package view

import domain.GameString

interface InputView {
    fun getInput(): GameString
}

class ConsoleInputView : InputView {
    override fun getInput(): GameString {
        while (true) {
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
