/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package kata.base

import kata.base.Category.*

class Yahtzee {
    companion object {
        fun score(
            category: Category,
            dice1: Int,
            dice2: Int,
            dice3: Int,
            dice4: Int,
            dice5: Int
        ): Int {
            val dices = listOf(dice1, dice2, dice3, dice4, dice5)

            val result = when (category) {
                CHANCE -> ::chance
                YAHTZEE -> ::yahtzee
                ACES -> ::aces
                TWOS -> ::twos
                THREES -> ::threes
                FOURS -> ::fours
                FIVES -> ::fives
                SIXES -> ::sixes
                THREE_OF_A_KIND -> ::threeOfAKind
                FOUR_OF_A_KIND -> ::fourOfAKind
                FULL_HOUSE -> ::fullHouse
            }

            return result(dices)
        }

        private fun aces(dices: List<Int>) = numerics(dices, 1)
        private fun twos(dices: List<Int>) = numerics(dices, 2)
        private fun threes(dices: List<Int>) = numerics(dices, 3)
        private fun fours(dices: List<Int>) = numerics(dices, 4)
        private fun fives(dices: List<Int>) = numerics(dices, 5)
        private fun sixes(dices: List<Int>) = numerics(dices, 6)
        private fun numerics(dices: List<Int>, score: Int) = dices.filter { it == score }.sum()

        private fun yahtzee(dices: List<Int>) =
            if (dices.toSet().size == 1) 50
            else 0

        private fun chance(dices: List<Int>) = dices.sum()

        private fun threeOfAKind(dices: List<Int>) = nOfAKind(3, dices)
        private fun fourOfAKind(dices: List<Int>) = nOfAKind(4, dices)

        private fun fullHouse(dices: List<Int>): Int {
            val unique = dices.distinct()
            if (unique.size != 2) return 0

            val firstDice = unique.first()
            val countOfFirstDices = dices.count { it == firstDice }

            val secondDice = unique[1]
            val countOfSecondDices = dices.count { it == secondDice }

            return if (countOfFirstDices > 3 || countOfSecondDices > 3) 0
            else 25
        }

        private fun nOfAKind(requiredSimilarDices: Int, dices: List<Int>): Int {
            val unique = dices.distinct()

            val numberWithNOfAKind = unique.firstOrNull { u ->
                dices.count { it == u } >= requiredSimilarDices
            } ?: 0

            val scoringDices = dices.filter { it == numberWithNOfAKind }.take(requiredSimilarDices)

            return scoringDices.sum()
        }
    }
}


fun main() = print("Hello, Yahtzee!")
