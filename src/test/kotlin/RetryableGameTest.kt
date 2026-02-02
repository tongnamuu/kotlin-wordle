
import domain.Constant
import domain.GameString
import domain.RetryableGame
import domain.WordleGame
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import view.InputView
import view.Instruction
import view.ResultView

class RetryableGameTest {
    @Test
    fun `게임은 최대 6번까지 시도할 수 있다`() {
        val wrongAnswer = GameString("wrong")
        val answer = GameString("right")

        val mockInputView = InputView { wrongAnswer }
        var printResultCallCount = 0
        val mockResultView = ResultView { printResultCallCount++ }
        val mockInstruction =
            object : Instruction {
                override fun startGame() {
                }

                override fun endGame(currentRound: Int) {
                }
            }

        val retryableGame = RetryableGame(WordleGame(), mockResultView, mockInputView, mockInstruction)
        retryableGame.run(answer)

        // then
        assertEquals(Constant.MAX_GAME_TRY_COUNT, printResultCallCount)
    }

    @Test
    fun `정답을 맞추면 즉시 종료한다`() {
        // given
        val wrongAnswer = GameString("right")
        val answer = GameString("right")

        val mockInputView = InputView { wrongAnswer }

        var printResultCallCount = 0
        val mockResultView = ResultView { printResultCallCount++ }
        val mockInstruction =
            object : Instruction {
                override fun startGame() {
                }

                override fun endGame(currentRound: Int) {
                }
            }

        // when
        val retryableGame = RetryableGame(WordleGame(), mockResultView, mockInputView, mockInstruction)
        retryableGame.run(answer)

        // then
        assertEquals(1, printResultCallCount)
    }
}
