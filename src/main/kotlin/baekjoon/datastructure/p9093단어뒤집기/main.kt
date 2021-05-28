package baekjoon.datastructure.p9093단어뒤집기

import java.util.*

fun main() {
    val scr = Scanner(System.`in`)
    val T = scr.nextInt()
    scr.nextLine()

    val sb = StringBuffer()
    for(i in 0 until T) {
        val str = scr.nextLine()

        val elements = str.split(" ")

        for(element in elements) {
            sb.append(element.reversed() + " ")
        }

        sb.append("\n")
    }

    print(sb.toString())
}