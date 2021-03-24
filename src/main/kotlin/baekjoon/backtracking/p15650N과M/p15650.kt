package baekjoon.backtracking.p15650N과M

import java.util.*

var N: Int = 0
var M: Int = 0
val sb = StringBuffer()

fun main() {
    val scr = Scanner(System.`in`)

    N = scr.nextInt()
    M = scr.nextInt()

    for(i in 1..N) {
        val str = StringBuffer()
        dfs(i, str.append(i).append(" "), 1)
    }

    print(sb.toString())
}

fun dfs(n:Int, str: StringBuffer,count: Int) {
    if(count == M) {
        sb.append(str.toString() + "\n")
        return
    }

    val n = n+1
    for(i in n..N) {
        var s = StringBuffer(str.toString())
        dfs(i, StringBuffer(s.append(i).append(" ")), count+1)
//        dfs(i, StringBuffer(str.append(i).append(" ")), count+1)
    }
}