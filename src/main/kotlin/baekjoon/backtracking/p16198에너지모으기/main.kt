package baekjoon.backtracking.p16198에너지모으기

import java.util.*

var energyBalls = mutableListOf<Int>()
var N: Int = 0
var max = Int.MIN_VALUE

fun main() {
    val scr = Scanner(System.`in`)
    N = scr.nextInt()

    for (i in 0 until N) {
        val element = scr.nextInt()
        energyBalls.add(element)
    }

    doAlgorithm(0, 0, N)

    println(max)
}

fun doAlgorithm(count: Int, value: Int, size: Int) {
    if (energyBalls.size == 2) {
        max = if (max < value) value else max
        return
    }

    for (i in 1..size - 2) {
        val temp = energyBalls[i]
        val v = value + (energyBalls[i - 1] * energyBalls[i + 1])
        energyBalls.removeAt(i)
        doAlgorithm(count+1, v, size-1)
        energyBalls.add(i, temp)
    }
}