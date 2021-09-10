package baekjoon.ds.stack.p17413단어뒤집기2

import java.util.*

fun main() {
    val scr = Scanner(System.`in`)

//    var str = "baekjoon online judge"
//    var str = "<open>tag<close>"
//    var str = "<ab cd>fe hg<ij kl>"
//    var str = "one1 two2 three3 4fourr 5five 6six"
//    var str = "<int><max>2147483647<long long><max>9223372036854775807"
//    var str = "<problem>17413<is hardest>problem ever<end>"
//    var str = "<   space   >space space space<    spa   c e>"

    var str = scr.nextLine();

    var len = str.length
    var idx = 0
    var startIdx = 0
    var endIdx = 0

    var result = ""
    var substr = ""
    var findIdx = 0

    while(idx < len) {
//        println(str)

        if(str[0] == '<') {
            findIdx = str.indexOf('>')
            substr = str.substring(0, findIdx + 1)

            result += substr
            str = str.substring(findIdx + 1)
            len = str.length
        }
        else {
            findIdx = str.indexOfFirst {
                it == '<'
            }
            var splitedStrs = emptyList<String>()

            if(findIdx == -1) {
                idx = len

                substr = str.substring(0, len)
                splitedStrs = substr.split(" ")

                for(s in splitedStrs) {
                    result += s.reversed() + " "
                }

                val last = result.lastIndexOf(" ")
                result = result.substring(0, last)
            }else {
                idx = findIdx
                substr = str.substring(0, findIdx)

                splitedStrs = substr.split(" ")

                for(s in splitedStrs) {
                    result += s.reversed() + " "
                }

                val last = result.lastIndexOf(" ")
                result = result.substring(0, last)
                str = str.substring(findIdx)
                len = str.length
                idx = 0 // 요거 다시 생각
            }
        }
    }

    println(result)
}

//fun main() {
//    val str = "abc"
//
//    println(str.indexOf('d'))
//}