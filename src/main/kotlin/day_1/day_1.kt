package day_1

import java.io.File

class Elf(cals: Int) {
    var calories: Int = cals
}

fun findMaxCalories(): Int {
    val elves: MutableList<Elf> = mutableListOf()
    var cur: Int = 0
    File("src/main/kotlin/day_1/input.txt").forEachLine {
        if (it.isBlank()) {
            elves.add(Elf(cur))
            cur = 0
        } else {
            cur += it.toInt()
        }
    }
    return elves.maxOf { elf: Elf -> elf.calories }
}

fun find3MaxCalories(): Int {
    val elves: MutableList<Elf> = mutableListOf()
    var cur: Int = 0
    File("src/main/kotlin/day_1/input.txt").forEachLine {
        if (it.isBlank()) {
            elves.add(Elf(cur))
            cur = 0
        } else {
            cur += it.toInt()
        }
    }
    elves.sortBy { elf -> elf.calories }
    return elves[elves.size-1].calories + elves[elves.size-2].calories + elves[elves.size-3].calories
}