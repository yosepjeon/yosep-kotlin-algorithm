package baekjoon.backtracking.p2529부등호

import java.util.*

var k = 0
var inEqualitySigns: Array<String>? = null
var visited: Array<Boolean>? = null
var results = mutableListOf<String>()

fun main() {
    val scr = Scanner(System.`in`)

    k = scr.nextInt()

    visited = Array<Boolean>(10) { false }
    inEqualitySigns = Array<String>(k) { "" }
    for (i in 0 until k) {
        val element = scr.next()

        inEqualitySigns!![i] = element
    }
    doAlgorithm(0, "", -1)

    results.sort()
    println(results[results.size-1])
    println(results[0])
}

fun doAlgorithm(count: Int, value: String, prev: Int) {
    if (count == k) {
        results.add(value)
        return
    }


    for (i in 0..9) {
        if (visited!![i]) {
            continue
        }

        if (prev == -1) {
            visited!![i] = true
            doAlgorithm(count, value + i, i)
            visited!![i] = false
        } else {
            if (inEqualitySigns!![count] == "<") {
                if (prev < i) {
                    visited!![i] = true
                    doAlgorithm(count + 1, value + i, i)
                    visited!![i] = false
                } else {
                    continue
                }
            } else {
                if (prev > i) {
                    visited!![i] = true
                    doAlgorithm(count + 1, value + i, i)
                    visited!![i] = false
                } else {
                    continue
                }
            }
        }
    }

}