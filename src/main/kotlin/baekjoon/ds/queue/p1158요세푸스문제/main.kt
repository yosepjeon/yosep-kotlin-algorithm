package baekjoon.ds.queue.p1158요세푸스문제

import java.util.*

fun main() {
    val scr = Scanner(System.`in`)

    val N = scr.nextInt()
    val K = scr.nextInt()

    val queue = LinkedList<Int>()

    for (i in 1..N) {
        queue.add(i)
    }

    var queueSize = queue.size
    var count = 1
    var result = "<"

    while (queueSize >= 0) {
        val element = queue.poll()

        if(count < K) {
            queue.add(element)
            count++
        }else {
            queueSize--
            result += element
            count = 1

            if(queueSize == 0)
                break
            result += ", "
        }
    }

    result += ">"

    print(result)
}