package baekjoon.bruteforce.p2309일곱난쟁이

import java.util.*

var check = mutableListOf<Boolean>()
var endFlag = false
var dwarfs = mutableListOf<Int>()

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    var i = 0
    var j = 0
    while (i < 9) {
        check.add(false)
        var n = sc.nextInt()
        dwarfs.add(n)
        i++
    }

    dwarfs.sortWith(kotlin.Comparator { o1, o2 -> o1 - o2 })

    selectDwarf(0,0, "")
}

fun selectDwarf(count:Int, total:Int, s: String) {
    if(count == 7 && total == 100) {
//        println("length: ${s.length}")
        print(s)
//        println("tatal=$total")
        endFlag = true
        return
    }

    if(count >= 7 && total != 100) {
        return
    }


    var i = 0
    while(i<9) {
        if(check[i]) {
            i++
            continue
        }

        check[i] = true
        selectDwarf(count+1,total + dwarfs[i],s + "${dwarfs[i]}\n")
        check[i] = false

        if(endFlag) {
            System.exit(0)
        }
        i++
    }
}

//"$dwarfs[i]\n"