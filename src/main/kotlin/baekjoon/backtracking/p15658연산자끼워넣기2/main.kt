package baekjoon.backtracking.p15658연산자끼워넣기2

import java.util.*

var N = 0
var max = Int.MIN_VALUE
var min = Int.MAX_VALUE

val elements = mutableListOf<Int>()
val operators = mutableListOf<Int>()

fun main() {
    val scr = Scanner(System.`in`)

    N = scr.nextInt()

    for (i in 0 until N) {
        val element = scr.nextInt()
        elements.add(element)
    }

    for (i in 0 until 4) {
        val operator = scr.nextInt()
        operators.add(operator)
    }

    doAlgorithm(1, elements[0])

    println(max)
    println(min)
}

fun doAlgorithm(count: Int, prev: Int) {
    if (count >= N) {
        if (prev > max) {
            max = prev
        }

        if (prev < min) {
            min = prev
        }

        return
    }

    var value = 0

    for (i in 0 until 4) {
        if (operators[i] > 0) {
            when (i) {
                0 -> {
                    operators[i] -= 1
                    value = prev + elements[count]
                    doAlgorithm(count+1, value)
                    operators[i] += 1
                }
                1 -> {
                    operators[i] -= 1
                    value = prev - elements[count]
                    doAlgorithm(count+1, value)
                    operators[i] += 1
                }
                2 -> {
                    operators[i] -= 1
                    value = prev * elements[count]
                    doAlgorithm(count+1, value)
                    operators[i] += 1
                }
                3 -> {
                    operators[i] -= 1
                    value = prev / elements[count]
                    doAlgorithm(count+1, value)
                    operators[i] += 1
                }
            }
        } else {
            continue
        }
    }
}