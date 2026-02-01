
import domain.GameInitializer
import domain.RetryableGame
import domain.WordleGame
import view.ConsoleInputView
import view.ConsoleInstruction
import view.ConsoleResultView

fun main() {
    val resultView = ConsoleResultView()
    val inputView = ConsoleInputView()
    val instruction = ConsoleInstruction()
    val wordleGame = WordleGame()
    val game = RetryableGame(wordleGame, resultView, inputView, instruction)
    val start = GameInitializer()
    val answer = start.findAnswer()
    game.run(answer)
}
