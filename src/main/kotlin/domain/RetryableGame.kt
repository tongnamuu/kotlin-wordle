package domain

import view.InputView
import view.Instruction
import view.ResultView

class RetryableGame(val wordleGame: WordleGame, val resultView: ResultView, val input: InputView, val instruction: Instruction) {
    fun run(answer: GameString) {
        var currentCount = 0
        instruction.startGame()
        while (currentCount < Constant.MAX_GAME_TRY_COUNT) {
            val input = input.getInput()
            val gameResult = wordleGame.calculateResult(input, answer)
            resultView.processResult(gameResult)
            currentCount++
            if (gameResult.isSuccess) {
                break
            }
        }
        instruction.endGame(currentCount)
    }
}
