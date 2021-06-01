package baekjoon.ds.stack.p10828스택

import java.util.*

fun main() {
    val scr = Scanner(System.`in`)

    val N = scr.nextInt()
    scr.nextLine()
    val stack = Stack<Int>()

    val sb = StringBuffer()

    for(i in 0 until N) {
        val command = scr.nextLine()

        if(command.contains("push")) {
            stack.push(command.split(" ")[1].toInt())
        }else if(command.contains("pop")) {
            if(stack.isEmpty()) {
                sb.append("-1\n")
            }else {
                sb.append("${stack.pop()}\n")
            }
        }else if(command.contains("size")) {
            sb.append("${stack.size}\n")
        }else if(command.contains("empty")) {
            if(stack.isEmpty()) {
                sb.append("1\n")
            }else {
                sb.append("0\n")
            }
        }else if(command.contains("top")) {
            if(stack.isEmpty()) {
                sb.append("-1\n")
            }else {
                sb.append("${stack.peek()}\n")
            }
        }
    }

    print(sb.toString())
}