package view

import domain.vo.GameResult

interface ResultView {
    fun processResult(gameResult: GameResult)
}

class ConsoleResultView : ResultView {
    val gameResults = mutableListOf<String>()

    override fun processResult(gameResult: GameResult) {
        val resultString = gameResult.emojiArray.joinToString("")
        this.gameResults.add(resultString)
        gameResults.map { println(it) }
        if (gameResult.isSuccess) {
            println("성공입니다!")
        }
    }
}
