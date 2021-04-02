package baekjoon.backtracking.p10974모든순열

import java.util.*

var N = 0
var arr: Array<Int>? = null
var visited: Array<Boolean>? = null

fun main() {
    val scr = Scanner(System.`in`)

    N = scr.nextInt()

    arr = Array<Int>(N) { 0 }
    visited = Array<Boolean>(N) { false }

    for (i in 0 until N) {
        arr!![i] = i + 1
    }

    doPermutation(0, "")
}

fun doPermutation(count: Int, str: String) {
    if (count == N) {
        println(str)
    }

    for (i in 0 until N) {
        if(visited!![i])
            continue
        visited!![i] = true
        doPermutation(count + 1, str + arr!![i] + " ")
        visited!![i] = false
    }
}