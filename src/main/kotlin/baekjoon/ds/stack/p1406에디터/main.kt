package baekjoon.ds.stack.p1406에디터

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val str = reader.readLine()
    val M = reader.readLine().toInt()

    val linkedList = LinkedList<Char>()
    str.forEach {
        linkedList.add(it)
    }
    val listIterator = linkedList.listIterator()

    while (listIterator.hasNext()) {
        listIterator.next()
    }
    val result = StringBuffer()

    for (i in 0 until M) {
        val command = reader.readLine()
        when {
            command[0] == 'L' -> {
                if (listIterator.hasPrevious()) {
                    listIterator.previous()
                }
            }
            command[0] == 'D' -> {
                if (listIterator.hasNext()) {
                    listIterator.next()
                }
            }
            command[0] == 'B' -> {
                if (listIterator.hasPrevious()) {
                    listIterator.previous()
                    listIterator.remove()
                }
            }
            command[0] == 'P' -> {
                listIterator.add(command[2])
            }
        }
    }

    linkedList.forEach {
        result.append(it)
    }

    print(result.toString())
}

//fun main() {
//    val reader = BufferedReader(InputStreamReader(System.`in`))
//    val writer = BufferedWriter(OutputStreamWriter(System.`out`))
//
//    val str = reader.readLine()
//    val M = reader.readLine().toInt()
//
//    val linkedList = LinkedList<Char>()
//    val listIterator = linkedList.listIterator()
//
//    while(listIterator.hasNext()) {
//        listIterator.next()
//    }
//
//    str.forEach {
//        linkedList.add(it)
//    }
//    var size = linkedList.size
//
//    var index = str.length
//    val result = StringBuffer()
//
//    for(i in 0 until M) {
//        val command = reader.readLine()
//        when {
//            command[0] == 'L' -> {
//                if(index > 0) {
//                    index--
//                }
//            }
//            command[0] == 'D' -> {
//                if(index < size) {
//                    index++
//                }
//            }
//            command[0] == 'B' -> {
//                if(index > 0) {
//                    linkedList.removeAt(index - 1)
////                    linkedList.listIterator(index).remove()
//                    size--
//                    index--
//                }
//            }
//            command[0] == 'P' -> {
//                linkedList.add(index, command[2])
////                linkedList.listIterator(index).add(command[2])
//                size++
//                index++
//            }
//        }
//    }
//
//    linkedList.forEach {
//        writer.write(it.toString())
//    }
//
//    writer.flush()
//    writer.close()
//}