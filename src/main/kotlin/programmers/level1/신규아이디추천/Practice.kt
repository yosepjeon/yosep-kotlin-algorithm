package programmers.level1.신규아이디추천

class Practice {
}

fun main() {
    var linkedHashSet = linkedSetOf<Char>()
    val v = "ssstriing"

    v.forEach { linkedHashSet.add(it) }

    println(String(linkedHashSet.toCharArray()))

    val c = "AGD%#$"
    println(c.toLowerCase())
}