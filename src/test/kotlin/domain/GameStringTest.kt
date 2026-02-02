package domain

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class GameStringTest {
    @Test
    fun `길이는 GAME_STRING_LENGTH 와 같아야 한다`() {
        val input = "abcde"
        assertDoesNotThrow { GameString(input) }
    }

    @Test
    fun `길이는 GAME_STRING_LENGTH 와 같지 않다면 예외가 발생한다`() {
        val input = "abcdef"
        assertThrows(IllegalArgumentException::class.java)  {
            GameString(input)
        }
    }

    @Test
    fun `숫자가 포함된다면 예외가 발생한다`() {
        val input = "123ab"
        assertThrows(IllegalArgumentException::class.java) { GameString(input) }
    }
}
