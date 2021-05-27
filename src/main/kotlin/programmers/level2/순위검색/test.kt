package programmers.level2.순위검색

import java.util.*

fun main() {
    val list = mutableListOf<Int>()
    val scr = Scanner(System.`in`)

//    for(i in 0 until 10) {
//        val n = (i+1)
//        list.add(n)
//    }

    list.add(1)
    list.add(2)
    list.add(3)
    list.add(10)
    list.add(20)

    val idx = Collections.binarySearch(list,3)


    println("idx: $idx")

    // 4 이상인 값들의 개수
    if(idx >= 0) {
        println(list.size - idx)
    }else {
        println(list.size + idx + 1)
    }


//    println("value: ${list[idx]}")
}