package baekjoon.ds.queue.p10845큐

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val queue = LinkedList<Int>()
    val sb = StringBuffer()

    for (i in 0 until N) {
        val command = br.readLine().split(" ")

        when {
            command[0] == "push" -> {
                queue.add(command[1].toInt())
            }
            command[0] == "pop" -> {
                if (queue.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${queue.poll()}\n")
                }
            }
            command[0] == "size" -> {
                sb.append("${queue.size}\n")
            }
            command[0] == "empty" -> {
                if (queue.isEmpty()) {
                    sb.append("1\n")
                } else {
                    sb.append("0\n")
                }
            }
            command[0] == "front" -> {
                if (queue.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${queue.first}\n")
                }
            }
            command[0] == "back" -> {
                if (queue.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${queue.last}\n")
                }
            }
        }
    }

    print(sb.toString())
}