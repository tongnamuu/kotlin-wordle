import domain.RetryableGame
import domain.Start
import domain.WordleGame
import view.ConsoleInputView
import view.ConsoleResultView

fun main() {
    val resultView = ConsoleResultView()
    val inputView = ConsoleInputView()
    val wordleGame = WordleGame()
    val game = RetryableGame(wordleGame, resultView, inputView)
    val start = Start()
    val answer = start.findAnswer()
    game.run(answer);
}
