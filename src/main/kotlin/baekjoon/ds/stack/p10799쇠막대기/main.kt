package baekjoon.ds.stack.p10799쇠막대기

import java.util.*

fun main() {
    val scr = Scanner(System.`in`)

    val input = scr.next()

    var index = 0
    val inputLen = input.length
    val leftParenthesesStack = Stack<Char>()
    var count = 0

    for(i in 0 until inputLen) {
        if(input[i] == '(') {
            leftParenthesesStack.push(input[i])
        }else {
            if(input[i-1] == '(') {
                leftParenthesesStack.pop()
                count += leftParenthesesStack.size
            }else {
                leftParenthesesStack.pop()
                count += 1
            }
        }
    }

    println(count)
}