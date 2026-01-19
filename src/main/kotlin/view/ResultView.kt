package view

import domain.vo.GameResult

class ResultView {

    val gameResults = mutableListOf<String>()

    fun printResult(gameResult: GameResult) {
        val resultString = gameResult.emojiArray.joinToString("")
        this.gameResults.add(resultString)
        gameResults.map { println(it) }
        if (gameResult.isSuccess) {
            println("성공입니다!")
        }
    }
}
