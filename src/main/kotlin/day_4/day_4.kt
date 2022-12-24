package day_4

import java.io.File
import java.util.function.BiFunction
import java.util.function.IntConsumer
import kotlin.streams.toList

fun numOverlappingElves(): Int {
    var num = 0
    File("src/main/kotlin/day_4/input.txt").forEachLine {
        val elves = it.split(",")
        val elf1Bounds = elves[0].split("-")
        val elf2Bounds = elves[1].split("-")
        val elf1 = Bounds(elf1Bounds[0].toInt(), elf1Bounds[1].toInt())
        val elf2 = Bounds(elf2Bounds[0].toInt(), elf2Bounds[1].toInt())
        if (elf1.overlaps(elf2) || elf2.overlaps(elf1)) {
            num++
        }
    }
    return num
}

class Bounds(private val lower: Int, private val upper: Int) {
    fun fullyContains(other: Bounds): Boolean {
        return other.lower >= lower && other.upper <= upper
    }
    fun overlaps(other: Bounds): Boolean {
        return other.lower <= upper && other.upper >= lower
    }

    override fun toString(): String {
        return "Bounds($lower-$upper)"
    }
}
