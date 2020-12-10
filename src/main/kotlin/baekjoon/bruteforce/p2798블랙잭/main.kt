package baekjoon.bruteforce.p2798블랙잭

import java.util.*

var N:Int = 0
var M:Int = 0

fun main(args: Array<String>) {
    val scr = Scanner(System.`in`)

    N = scr.nextInt()
    M = scr.nextInt()

    var arr = IntArray(N) { -1 }

    for(i in 0 until N) {
        val element = scr.nextInt()
        arr[i] = element
    }

    val pq = calculate(arr)

    println(pq.poll())
}

fun calculate(arr: IntArray): PriorityQueue<Int> {
    val pq = PriorityQueue<Int>(kotlin.Comparator { o1, o2 ->
        o2 - o1
    })

    for(i in 0 until N) {
        for(j in i+1 until N) {
            for(k in j+1 until N) {
                val num = arr[i] + arr[j] + arr[k]

                if(num == M) {
//                    println("Hit")
                    pq.add(num)
                    return pq
                }

                if(num > M) {
                    continue
                }

                if(num < M) {
                    pq.add(num)
                }
            }
        }
    }

    return pq
}