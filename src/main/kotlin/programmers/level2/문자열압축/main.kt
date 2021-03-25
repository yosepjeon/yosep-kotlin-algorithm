package programmers.level2.문자열압축

import java.util.*

class Solution {
    fun solution(s: String): Int {
        var answer = Int.MAX_VALUE

        var strLen = s.length
        var compactIndex = strLen / 2
        var compareStr = s.substring(compactIndex, strLen)

        for (i in 1..compactIndex) {
            var resultStr = ""
            var index = 0

            while (index <= strLen - (i * 2)) {
                var subStr = s.substring(index, index + i)
                index += i
                var count = 1

                var compareStr = s.substring(index, index + i)
                while (compareStr.contains(subStr) && index <= strLen - (i)) {
                    count += 1
                    index += i

                    if(index >= strLen || index + i > strLen)
                        break;
                    compareStr = s.substring(index, index + i)
                }

                if (count > 1) {
                    subStr = StringBuffer().append(count).append(subStr).toString()
                } else {
                    subStr = subStr
                }

                resultStr += subStr
//                resultStr = subStr + s.substring(index, s.length)
            }


            if(index != strLen) {
                resultStr += s.substring(index, strLen)
            }
//            println("$resultStr - $index")
            if (answer > resultStr.length)
                answer = resultStr.length
        }

        if(answer == Int.MAX_VALUE)
            answer = 1

        return answer
    }
}

fun main() {
    val scr = Scanner(System.`in`)
    val s = scr.next()
    val solution = Solution()

    println(solution.solution(s))
}