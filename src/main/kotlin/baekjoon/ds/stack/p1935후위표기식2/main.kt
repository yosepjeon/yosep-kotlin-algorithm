package baekjoon.ds.stack.p1935후위표기식2

import java.util.*

fun main() {
    val scr = Scanner(System.`in`)

    val N = Integer.parseInt(scr.next())
    val str = scr.next();

    val carr = str.toCharArray()
    val list = mutableListOf<String>()
    val strLen = str.length
    var operandCount = 0
    val map = mutableMapOf<Char, Int>()

    val operandValues = mutableListOf<Int>()
    for (i in 0 until N) {
        val value = scr.next().toInt()
        map.putIfAbsent('A' + i, value)
        operandValues.add(value)
    }

    for (i in 0 until strLen) {
        if (carr[i] == '+' || carr[i] == '-' || carr[i] == '*' || carr[i] == '/') {
            list.add(carr[i].toString())
        } else {
            list.add(map[carr[i]]!!.toDouble().toString())
        }
    }

//    println(list)
    val stack = Stack<String>()
    for (i in 0 until strLen) {

        if (list[i] == "+") {
            val n1 = stack.pop().toDouble()
            val n2 = stack.pop().toDouble()
            var result = n2 + n1
            stack.push(String.format("%.2f", result))
        } else if (list[i] == "-") {
            val n1 = stack.pop().toDouble()
            val n2 = stack.pop().toDouble()
            var result = n2 - n1
            stack.push(String.format("%.2f", result))
        } else if (list[i] == "*") {
            val n1 = stack.pop().toDouble()
            val n2 = stack.pop().toDouble()
            var result = n2 * n1
            stack.push(String.format("%.2f", result))
        } else if (list[i] == "/") {
            val n1 = stack.pop().toDouble()
            val n2 = stack.pop().toDouble()
            var result = n2 / n1
            stack.push(String.format("%.2f", result))
        } else {
            stack.push(list[i])
        }
    }

    val a = String.format("%.2f", stack.pop().toDouble())
    println(a)
}