package baekjoon.ds.stack.p17298오큰수

import java.lang.StringBuilder
import java.util.*

fun main(args: Array<String>) {
    val scr = Scanner(System.`in`)
    val N = scr.nextInt()
    val stack = Stack<Int>()
    val arr = IntArray(N)
    for (i in 0 until N) {
        val element = scr.nextInt()
        arr[i] = element
    }

    val index = 0
    var i = 0

    stack.push(0)
    for (i in 1 until N) {

        while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
            val index = stack.pop()
            arr[index] = arr[i]
        }



        stack.push(i)
    }

    stack.push(N - 1)

    while (!stack.isEmpty()) {
        val index = stack.pop()
        arr[index] = -1
    }

    val sb = StringBuilder()
    for (i in 0 until N) {
        sb.append("${arr[i]} ")
    }

    print(sb.toString())
}

//import java.util.*

//fun main() {
//    val scr = Scanner(System.`in`)
//    val N = scr.nextInt()
//
//    val sb = StringBuilder()
//    val arr = IntArray(N)
//
//    for (i in 0 until N) {
//        val element = scr.nextInt()
//        arr[i] = element
//    }
//
//
//    var i = 0
//    while (i < N) {
//
//        val element = arr[i]
//        var isExist = false
//
//        for (j in i + 1 until N) {
//            if (element < arr[j]) {
//                isExist = true
//
//                for (k in i until j) {
//                    sb.append("${arr[j]} ")
//                }
//
//                i = j
//            }
//        }
//
//        if(!isExist) {
//            if(i != N-1) {
//                sb.append("-1 ")
//                i++
//            }else {
//                sb.append("-1 ")
//                break
//            }
//        }
//    }
//
//    print(sb.toString())
//}
