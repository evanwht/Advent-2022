package day_3

import java.io.File
import java.util.function.BiFunction
import java.util.function.IntConsumer
import kotlin.streams.toList

const val a = 97
const val A = 65

fun searchRucksacks(): Int {
    var points = 0
    File("src/main/kotlin/day_3/input.txt").forEachLine {
        val items = mutableSetOf<Int>()

        val p1 = it.substring(0, it.length/2)
        p1.chars().forEach(items::add)

        val p2 = it.substring(it.length/2, it.length)
        var c = -1
        p2.chars().forEach { i ->
            if (items.contains(i)) {
                c = i
            }
        }
        points += getItemPriority(c)
    }
    return points
}

fun searchRucksacksForBadges(): Int {
    var points = 0
    val items = mutableMapOf<Int, MutableSet<Int>>()
    var group = 0
    File("src/main/kotlin/day_3/input.txt").forEachLine {
        group++
        it.chars().forEach { i ->
            val g = items.getOrDefault(i, mutableSetOf())
            g.add(group)
            items[i] = g
        }
        if (group == 3) {
            items.forEach { (item, elves) ->
                if (elves.size == 3) {
                    points += getItemPriority(item)
                }
            }
            items.clear()
            group = 0
        }
    }
    return points
}

fun getItemPriority(item: Int): Int {
    var amt = (item-a) + 1
    if (amt < 0) {
        // c is uppercase
        amt = item - A + 27
    }
    return amt
}