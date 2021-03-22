package baekjoon.graph.p2458키순서

import java.util.*

class Main {
}

class Student(
    val id: Int,
    val gtList: List<Student>,
    val ltList: List<Student>,
)

fun main() {
    val scr = Scanner(System.`in`)

    val n = scr.nextInt()
    val m = scr.nextInt()

    val students = arrayOfNulls<Int>(n)
    val map = Array<Array<Int>>(n) { Array<Int>(n) { 0 } }
    val reverseMap = Array<Array<Int>>(n) { Array<Int>(n) { 0 } }

    val floydWashalMap = Array<Array<Int>>(n) { Array<Int>(n) { 0 } }

    for(i in 0 until n) {
        val start = scr.nextInt() - 1
        val end = scr.nextInt() - 1

        map[start][end] = 1
        reverseMap[end][start] = 1
    }

    for(i in 0 until n) {
        for(j in 0 until n) {
            if(i == j) {
                map[i][j] = 1
                reverseMap[i][j] = 1
            }
        }
    }

    for(b in 0 until n) {
        for(a in 0 until n) {
            for(c in 0 until n) {
                if(map[a][b] == 1 && map[b][c] == 1) {
                    floydWashalMap[a][c] = 1
                }
            }
        }
    }

    for(b in 0 until n) {
        for(a in 0 until n) {
            for(c in 0 until n) {
                if(reverseMap[a][b] == 1 && reverseMap[b][c] == 1) {
                    floydWashalMap[a][c] = 1
                }
            }
        }
    }

    var result = 0
    for (a in 0 until n) {
        var count = 0
        for(b in 0 until n) {
            if(floydWashalMap[a][b] == 1)
                count++
        }

        if(count == n) {
            result++
        }
    }

    println(result)
}