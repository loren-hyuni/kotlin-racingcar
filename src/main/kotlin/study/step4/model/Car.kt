package study.step4.model

import study.step4.util.DigitGenerator
import study.step4.util.RandomDigit

private const val ADVANCE_BASE_DIGIT = 4

class Car(
    val name: String = "",
    private var location: Int = 0,
    private var racingTimes: Int = 0,
    private val digitGenerator: DigitGenerator = RandomDigit()
) {
    private val history = mutableListOf<Int>()

    fun move() {
        if (digitGenerator.getDigit() >= ADVANCE_BASE_DIGIT) {
            advance()
        } else {
            stop()
        }
    }

    private fun advance() {
        location++
        saveHistory()
    }

    private fun stop() {
        saveHistory()
    }

    private fun saveHistory() {
        racingTimes++
        history.add(location)
    }

    fun getLocation(): Int = location
    fun getRacingTimes(): Int = racingTimes
    fun getHistory(): List<Int> = history.toList()
}
