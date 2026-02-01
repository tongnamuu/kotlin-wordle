package view

import domain.Constant

interface Instruction {
    fun startGame()

    fun endGame(currentRound: Int)
}

class ConsoleInstruction : Instruction {
    override fun startGame() {
        println("WORDLE을 6번 만에 맞춰 보세요.")
        println("시도의 결과는 타일의 색 변화로 나타납니다.")
    }

    override fun endGame(currentRound: Int) {
        println("$currentRound / ${Constant.MAX_GAME_TRY_COUNT}")
    }
}
