package baekjoon.backtracking.p4344평균은넘겠지

import java.util.*

var C:Int = 0

fun main() {
    val scr = Scanner(System.`in`)

    C = scr.nextInt()

    val results = StringBuffer()
    for(i in 0 until C) {
        val N = scr.nextInt()
        val scores = mutableListOf<Int>()
        var total = 0
        for(j in 0 until N) {
            val score = scr.nextInt()
            total += score

            scores.add(score)
        }
        val avg = total/N
        var count = 0
        for(j in 0 until N) {
            if(scores[j] > avg)
                count++
        }

        val result = String.format("%.3f", count.toDouble()/N * 100)
        results.append("$result%\n")
    }

    print(results.toString())
}