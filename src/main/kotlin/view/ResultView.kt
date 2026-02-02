package view

import domain.vo.GameResult

fun interface ResultView {
    fun processResult(gameResult: GameResult)
}

class ConsoleResultView : ResultView {
    private val gameResults = mutableListOf<String>()

    override fun processResult(gameResult: GameResult) {
        val resultString = gameResult.emojiArray.joinToString("")
        this.gameResults.add(resultString)
        println()
        gameResults.forEach { println(it) }
        println()
        if (gameResult.isSuccess) {
            println("성공입니다!")
        }
    }
}
