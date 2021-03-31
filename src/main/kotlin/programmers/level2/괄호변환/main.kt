package programmers.level2.괄호변환

import java.util.*

fun main() {
    val scr = Scanner(System.`in`)

    val p = scr.next()
    val solution = Solution()

    println(solution.solution(p))
}

class Solution {
    fun solution(p: String): String {
        var answer = ""

        answer = doAlgorithm(p)

        return answer
    }

    fun doAlgorithm(p: String): String {
        var str = ""
        if (p == "")
            return ""

        var index = divideString(p)
        var u = getU(p, index)
        var v = getV(p, index)
//        println("u=$u v=$v")

        if(checkIsCorrectString(u)) {
            str += u
            str += doAlgorithm(v)
        }else {
            str += "("
            str += doAlgorithm(v)
            str += ")"

            var carr = u.toList()
            var index = 0
            var lastIndex = carr.size
            var sb = StringBuffer()
            for(c in carr) {
                if(index ==0 || index == lastIndex-1) {
                    index++
                    continue
                }

                if(c == '(')
                    sb.append(')')
                if(c == ')')
                    sb.append('(')
                index++
            }

            str += sb.toString()
        }

        return str
    }

    fun checkIsCorrectString(u: String): Boolean {
        val stack = Stack<Char>()
        var isCorrect = true

        u.forEach {
            if(it == ')') {
                if(stack.empty()) {
                    isCorrect = false
                    return@forEach
                }else {
                    stack.pop()
                }
            }else {
                stack.push(it)
            }
        }

        return isCorrect
    }

    fun divideString(p: String): Int {
        var left = 0
        var right = 0
        var index = 1
        for(it in p) {
            if (it == '(')
                left++

            if (it == ')')
                right++

            if (left > 0 && right > 0 && left == right) {
                break
            }

            index++
        }

        return index
    }

    fun getU(p: String, index: Int): String {
        return p.substring(0, index)
    }

    fun getV(p: String, index: Int): String {
        return p.substring(index)
    }
}

// ))))(((()( 반례