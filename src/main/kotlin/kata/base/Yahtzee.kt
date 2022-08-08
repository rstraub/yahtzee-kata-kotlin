/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package kata.base

import kata.base.Score.CHANCE

class Yahtzee {
    companion object {
        fun score(score: Score, dice1: Int, dice2: Int, dice3: Int, dice4: Int, dice5: Int) =
            if (score == CHANCE) chance(dice1, dice2, dice3, dice4, dice5)
            else yahtzee(dice1, dice2, dice3, dice4, dice5)

        private fun yahtzee(
            dice1: Int,
            dice2: Int,
            dice3: Int,
            dice4: Int,
            dice5: Int
        ) =
            if (setOf(dice1, dice2, dice3, dice4, dice5).size == 1) 50
            else 0

        private fun chance(
            dice1: Int,
            dice2: Int,
            dice3: Int,
            dice4: Int,
            dice5: Int
        ) = dice1 + dice2 + dice3 + dice4 + dice5
    }
}


fun main() = print("Hello, Yahtzee!")
