package programmers.level2.멀쩡한사각형

class Solution {
    fun solution(w: Int, h: Int): Long {
        var answer: Long = 0
        var w = w.toLong()
        var h = h.toLong()
        val gcd = getGcd(w,h)
        answer = ((w*h) - (w+h-gcd))

        return answer
    }

    fun getGcd(num1: Long, num2: Long):Long {
        var n1: Long
        var n2: Long
        var gcd:Long = 1
        if(num1 >= num2) {
            n1 = num1
            n2 = num2
        } else {
            n1 = num2
            n2 = num1
        }

        for(i in 1..n2) {
            if(n1 % i == 0.toLong() && n2 % i == 0.toLong()) {
                gcd = i
            }
        }

        return gcd
    }
}

fun main() {

}