package baekjoon.graph.p1967트리의지름

import java.util.*

class Main {
}

class Node(
    val id: Int,
    val parent: Node,
    val value: Int,
)

val max:Int = Int.MIN_VALUE

fun main() {
    val scr = Scanner(System.`in`)

    val n = scr.nextInt()
    val visited = arrayOfNulls<Boolean>(n)

    val edges = mutableMapOf<Int, MutableMap<Int,Boolean>>()


    for (i in 0 until n) {
        visited[i] = false
        edges[i] = mutableMapOf()
    }

    for(i in 1 until n) {
        val parentId = scr.nextInt()
        val childId = scr.nextInt()
        val value = scr.nextInt()

        edges[parentId]!![childId] = false
        edges[childId]!![parentId] = false
    }
}