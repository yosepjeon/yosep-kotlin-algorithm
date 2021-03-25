package programmers.level2.문자열압축

fun main() {
    var str = "ababcdcdababcdcda"
    val strLen = str.length

    var compactIndex = strLen/2
    str.contains("ababcdcd")
    var subStr = str.subSequence(compactIndex, strLen)

    println(subStr.contains("ababcdcd"))
}