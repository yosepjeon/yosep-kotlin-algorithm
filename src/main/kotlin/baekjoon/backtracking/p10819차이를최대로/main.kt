package baekjoon.backtracking.p10819차이를최대로

import java.util.*
import kotlin.math.abs

var max = Int.MIN_VALUE
val visited = mutableListOf<Boolean>()
var N = 0

fun main() {
    val scr = Scanner(System.`in`)

    val arr = mutableListOf<Int>()
    N = scr.nextInt()

    for(i in 0 until N) {
        val element = scr.nextInt()
        arr.add(element)
        visited.add(false)

    }

    for(i in 0 until N) {
        visited[i] = true
        getMax(1,i, arr, 0)
        visited[i] = false
    }

    println(max)
}

fun getMax(current:Int, selectedIndex:Int, arr: MutableList<Int>, value: Int) {
//    println("value: $value current: $current")
    if(current >= N) {
        if(value > max) {
            max = value
            return
        }
    }

    for(i in 0 until N) {
        if(visited[i])
            continue
        visited[i] = true
        var v = value
        v += abs(arr[selectedIndex] - arr[i])
        getMax(current+1,i, arr, v)
        visited[i] = false
    }

}