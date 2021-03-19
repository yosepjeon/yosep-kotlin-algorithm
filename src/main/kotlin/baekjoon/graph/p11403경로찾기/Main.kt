package baekjoon.graph.p11403경로찾기

import java.util.*

class Main {
}

fun main() {
    val scr = Scanner(System.`in`)

    val N = scr.nextInt()
    val M = scr.nextInt()

    val G = Array<Array<Int?>>(N) {
        arrayOfNulls<Int>(N)
    }

    for (a in 0 until N) {
        for (b in 0 until N) {
            G[a][b] = 0
        }
    }

    for (i in 0 until M) {
        val n = scr.nextInt() - 1
        val m = scr.nextInt() - 1
        G[n][m] = 1
    }

//    for (a in 0 until N) {
//        for (b in 0 until N) {
//            print("${G[a][b]} ")
//        }
//        println()
//    }
//    println()

    val floydG = Array<Array<Int?>>(N) {
        arrayOfNulls(N)
    }

    for (a in 0 until N) {
        for (b in 0 until N) {
            floydG[a][b] = G[a][b]
        }
    }

    // 거쳐가는 노드
    for (a in 0 until N) {
        // 출발 노드
        for (start in 0 until N) {
            // 도착 노드
            for (end in 0 until N) {
                if (G[start][a] == 1 && G[a][end] == 1) {
                    floydG[start][end] = 1
                    floydG[end][start] = 1
                    floydG[start][a] = 1
                    floydG[a][start] = 1
                    floydG[a][end] = 1
                    floydG[end][a] = 1
                }
            }
        }
    }

    println("G")
    for (a in 0 until N) {
        for (b in 0 until N) {
            print("${G[a][b]} ")
        }
        println()
    }
    println()

    println("floydG")
    for (a in 0 until N) {
        for (b in 0 until N) {
            print("${floydG[a][b]} ")
        }
        println()
    }
    println()

    var result = 0
    for (a in 0 until N) {
        var count = 0
        for (b in 0 until N) {
            if(floydG[a][b] == 1)
                count++
        }

        if(count == N-1)
            result++
    }

    println(result)
}