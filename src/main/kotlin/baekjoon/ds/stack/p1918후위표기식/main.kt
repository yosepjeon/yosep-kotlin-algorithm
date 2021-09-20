package baekjoon.ds.stack.p1918후위표기식

import java.util.*
import kotlin.collections.HashMap

val operators = HashMap<Char, Int>()

fun main() {
    val scr = Scanner(System.`in`)

    val input = scr.next()
    operators['*'] = 3
    operators['/'] = 3
    operators['+'] = 2
    operators['-'] = 2
    operators['('] = 1

    val postFixNotationGenerator = PostFixNotationGenerator(Stack())
    val postFix = postFixNotationGenerator.generatePostfix(input)

    print(postFix)
}

class PostFixNotationGenerator constructor(
    val stack: Stack<Char> = Stack(),
) {
    fun generatePostfix(infix: String): String {
        val sb = StringBuilder()

        infix.forEach { c ->

            when (c) {
                '+', '-', '*', '/' -> {
                    if (stack.isEmpty() || stack.peek() == '(') {
                        stack.push(c)
                    } else {
                        while (!stack.isEmpty() && operators[c]!! <= operators[stack.peek()]!!) {
                            sb.append(stack.pop())
                        }
                        stack.push(c)
                    }
                }
                '(' -> {
                    stack.push(c)
                }
                ')' -> {
                    while (stack.peek() != '(') {
                        val element = stack.pop()
                        sb.append(element)
                    }
                    stack.pop()
                }
                else -> {
                    sb.append(c)
                }
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop())
        }

        return sb.toString()
    }

}