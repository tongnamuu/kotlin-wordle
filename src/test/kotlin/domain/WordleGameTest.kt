package domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class WordleGameTest {
    @Test
    fun `정답을 맞추면 모두 초록색이다`() {
        val input = GameString("under")
        val answer = GameString("under")
        val game = WordleGame()
        val expected =
            listOf(
                Color.GREEN.colorBox,
                Color.GREEN.colorBox,
                Color.GREEN.colorBox,
                Color.GREEN.colorBox,
                Color.GREEN.colorBox,
            )

        val result = game.logic(input, answer).emojiArray

        Assertions.assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `입력문자열이 answer의 글자에 포함되어있으면 yellow`() {
        val input = GameString("uooon")
        val answer = GameString("under")
        val game = WordleGame()
        val expected =
            listOf(
                Color.GREEN.colorBox,
                Color.GREY.colorBox,
                Color.GREY.colorBox,
                Color.GREY.colorBox,
                Color.YELLOW.colorBox,
            )

        val result = game.logic(input, answer).emojiArray

        Assertions.assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `정답글자를 중복으로 입력할 경우 grey`() {
        val input = GameString("uuooo")
        val answer = GameString("under")
        val game = WordleGame()
        val expected =
            listOf(
                Color.GREEN.colorBox,
                Color.GREY.colorBox,
                Color.GREY.colorBox,
                Color.GREY.colorBox,
                Color.GREY.colorBox,
            )

        val result = game.logic(input, answer).emojiArray

        Assertions.assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `중복된 알파벳이 input에 더 많다면 answer 에 있는 개수보다 큰 경우는 Grey 로 처리한다 `() {
        val input = GameString("uuuuo")
        val answer = GameString("undeu")
        val game = WordleGame()
        val expected =
            listOf(
                Color.GREEN.colorBox,
                Color.YELLOW.colorBox,
                Color.GREY.colorBox,
                Color.GREY.colorBox,
                Color.GREY.colorBox,
            )

        val result = game.logic(input, answer).emojiArray
        Assertions.assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `answer 문자열에서 사용되지 않았고 가장 먼저 등장하는 인덱스를 찾아서 yellow 로 처리한다`() {
        val input = GameString("ououo")
        val answer = GameString("unueu")
        val game = WordleGame()
        val expected =
            listOf(
                Color.GREY.colorBox,
                Color.YELLOW.colorBox,
                Color.GREY.colorBox,
                Color.YELLOW.colorBox,
                Color.GREY.colorBox,
            )

        val result = game.logic(input, answer).emojiArray
        Assertions.assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `answer 문자열에서 사용되지 않았고 가장 먼저 등장하는 인덱스를 찾아서 yellow 로 처리한다 2`() {
        val input = GameString("unueu")
        val answer = GameString("ououo")
        val game = WordleGame()
        val expected =
            listOf(
                Color.YELLOW.colorBox,
                Color.GREY.colorBox,
                Color.YELLOW.colorBox,
                Color.GREY.colorBox,
                Color.GREY.colorBox,
            )

        val result = game.logic(input, answer).emojiArray
        Assertions.assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `모든 알파벳이 인덱스가 다른 위치에 존재한다면 모두 노란색인 결과를 반환한다`() {
        val input = GameString("abcde")
        val answer = GameString("badec")
        val game = WordleGame()
        val expected =
            listOf(
                Color.YELLOW.colorBox,
                Color.YELLOW.colorBox,
                Color.YELLOW.colorBox,
                Color.YELLOW.colorBox,
                Color.YELLOW.colorBox,
            )

        val result = game.logic(input, answer).emojiArray
        Assertions.assertThat(result).isEqualTo(expected)
    }
}
