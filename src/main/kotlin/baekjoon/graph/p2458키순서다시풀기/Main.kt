package baekjoon.graph.p2458키순서다시풀기

import java.util.*

class Main {
}

fun main() {
    val scr = Scanner(System.`in`)

    val n = scr.nextInt()
    val m = scr.nextInt()

    val students = arrayOfNulls<Int>(n)
    val map = Array<Array<Boolean>>(n) { Array(n) { false } }
    val reverseMap = Array<Array<Boolean>>(n) { Array(n) { false } }

//    val floydWashalMap = Array<Array<Boolean>>(n) { Array(n) { false } }
//    val reversFloydWashalMap = Array<Array<Boolean>>(n) { Array(n) { false } }

    for (i in 0 until m) {
        val start = scr.nextInt() - 1
        val end = scr.nextInt() - 1

        map[start][end] = true
        reverseMap[end][start] = true
    }

    for (b in 0 until n) {
        for (a in 0 until n) {
            for (c in 0 until n) {
                if (map[a][b] && map[b][c]) {
                    map[a][c] = true
                }
            }
        }
    }

    for (b in 0 until n) {
        for (a in 0 until n) {
            for (c in 0 until n) {
                if (reverseMap[a][b] && reverseMap[b][c]) {
                    reverseMap[a][c] = true
                }
            }
        }
    }

    for(a in 0 until n) {
        for(b in 0 until n) {
            map[a][b] = (map[a][b] || reverseMap[a][b])
        }
    }

    var result = 0

    loop1@for (a in 0 until n) {
        loop2@for (b in 0 until n) {
            if(a == b)
                continue@loop2

            if (!map[a][b])
                continue@loop1
        }

//        println("$a: $count")
        result++
    }

    println(result)
}