package baekjoon.수학.p2609최대공약수와_최소공배수

import java.util.*

fun main() {
    val scr = Scanner(System.`in`)

    val num1 = scr.nextInt()
    val num2 = scr.nextInt()

    val gcd = getGcdUsingRecursive(num1, num2)
    val lcm = getLcm(num1, num2, gcd)

    println(gcd)
    println(lcm)
}

fun getGcd(num1: Int, num2: Int): Int {
    val num = if (num1 >= num2) num2 else num1

    var gcd = 1
    for (i in 1..num) {
        if (num1 % i == 0 && num2 % i == 0)
            gcd = i
    }

    return gcd
}

fun getGcdUsingRecursive(num1: Int, num2: Int): Int {
    val num1 = if(num1 >= num2) num1 else num2
    val num2 = if(num1 == num2) num1 else num2

    if(num1 % num2 == 0) return num2
    return getGcdUsingRecursive(num2, num1 % num2)
}

fun getLcm(num1: Int, num2: Int, gcd: Int): Int {
    return num1 * num2 / gcd
}