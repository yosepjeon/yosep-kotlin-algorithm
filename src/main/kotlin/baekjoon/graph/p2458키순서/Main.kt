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

}