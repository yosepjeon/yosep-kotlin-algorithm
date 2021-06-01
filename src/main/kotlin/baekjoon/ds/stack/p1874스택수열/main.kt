package baekjoon.ds.stack.p1874스택수열

import java.util.*

fun main() {
    val stack = Stack<Int>()

    val scr = Scanner(System.`in`)
    val n = scr.nextInt()
    val list = mutableListOf<Int>()
    val result = mutableListOf<Int>()
    var index = 0
    val sb = StringBuffer()

    for(i in 1 .. n) {
        list.add(scr.nextInt())
    }

    for(i in 1 .. n) {
        stack.add(i)
        sb.append("+\n")

        while(!stack.isEmpty() && stack.peek() == list[index]) {
            result.add(stack.pop())
            sb.append("-\n")
            index++
        }
    }

    if(result == list) {
        print(sb.toString())
    }else {
        println("NO")
    }
}