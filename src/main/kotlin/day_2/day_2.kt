package day_2

import day_1.Elf
import java.io.File

// A = Rock, B = Paper, C = Scissors
// X = Rock, Y = Paper, Z = Scissors
fun calculateScore(): Int {
    var points = 0
    File("src/main/kotlin/day_2/input.txt").forEachLine {
        val plays = it.split(" ")
        val opponent = plays[0]
        when (plays[1]) {
            "X" -> {
                points += 1
                when (opponent) {
                    "A" -> points += 3
                    "C" -> points += 6
                }
            }
            "Y" -> {
                points += 2
                when (opponent) {
                    "B" -> points += 3
                    "A" -> points += 6
                }
            }
            "Z" -> {
                points += 3
                when (opponent) {
                    "C" -> points += 3
                    "B" -> points += 6
                }
            }
        }
    }
    return points
}

// A = Rock, B = Paper, C = Scissors
// X = Lose, Y = Tie, Z = Win
fun calculateCorrectScore(): Int {
    var points = 0
    File("src/main/kotlin/day_2/input.txt").forEachLine {
        val plays = it.split(" ")
        val opponent = plays[0]
        when (plays[1]) {
            "X" -> {
                when (opponent) {
                    "A" -> points += 3
                    "B" -> points += 1
                    "C" -> points += 2
                }
            }
            "Y" -> {
                points += 3
                when (opponent) {
                    "A" -> points += 1
                    "B" -> points += 2
                    "C" -> points += 3
                }
            }
            "Z" -> {
                points += 6
                when (opponent) {
                    "A" -> points += 2
                    "B" -> points += 3
                    "C" -> points += 1
                }
            }
        }
    }
    return points
}