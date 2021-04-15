package baekjoon.수학.p1629곱셈다시도전

import java.math.BigInteger
import java.util.*

fun main() {
    val scr = Scanner(System.`in`)

    val A = scr.nextBigInteger()
    val B = scr.nextBigInteger()
    val C = scr.nextBigInteger()

//    println(A.pow(2).mod(C))

    println(doAlgorithm(A, B, C).toString())
}

fun doAlgorithm(A: BigInteger, B: BigInteger, C: BigInteger): BigInteger {
    if (B == BigInteger.ONE) {
        println("!")
        return A.mod(C)
    }

    return doAlgorithm(A, BigInteger.ONE, C).mod(C).multiply(doAlgorithm(A, B.minus(BigInteger.ONE), C).mod(C)).mod(C)
}