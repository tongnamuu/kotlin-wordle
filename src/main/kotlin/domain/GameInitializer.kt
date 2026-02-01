package domain

import java.time.LocalDate
import java.time.temporal.ChronoUnit

class GameInitializer {
    fun findAnswer(): GameString {
        val words =
            javaClass.classLoader
                .getResourceAsStream("words.txt")
                ?.bufferedReader()
                ?.readLines()
                ?: throw IllegalStateException("words.txt not found")
        if (words.isEmpty()) {
            throw IllegalStateException("words.txt is Empty")
        }
        val startDate = LocalDate.of(2021, 6, 19)
        val daySinceStart = ChronoUnit.DAYS.between(startDate, LocalDate.now())
        val index = (daySinceStart % words.size).toInt()
        return GameString(words[index])
    }
}
