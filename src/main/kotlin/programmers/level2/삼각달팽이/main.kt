package programmers.level2.삼각달팽이

var triangle: Array<Array<Int>?>? = null

fun main() {
    val n = 100
    val solution = Solution()
    val result = solution.solution(n)

    result.forEach {
        print("$it ")
    }
}

class Solution {
    fun solution(n: Int): IntArray {
        var answer: IntArray
        triangle = Array(n) { null }

        for (i in 0 until n) {
            triangle!![i] = Array(i + 1) { -1 }
        }

        var row = 0
        var col = 0
        var direct = 0 // 0: 아래 1: 우 2: 상
        var total = 0
        loop@while (true) {
            total++
            println("row=$row, col=$col, total=$total")
            triangle!![row]!![col] = total
            when (direct) {
                0 -> {
                    if (row + 1 <= n - 1 && triangle!![row + 1]!![col] == -1) {
                        row++
                    } else {
                        direct = (direct + 1) % 3

                        if (col + 1 <= n - 1 && triangle!![row]!![col + 1] == -1) {
                            col++
                        } else {
                            break@loop
                        }
                    }
                }

                1 -> {
                    if (col + 1 <= n - 1 && triangle!![row]!![col + 1] == -1) {
                        col++
                    } else {
                        direct = (direct + 1) % 3

                        if (row - 1 >= 0 && col - 1 >= 0 && triangle!![row - 1]!![col - 1] == -1) {
                            row--
                            col--
                        } else {
                            break@loop
                        }
                    }
                }

                2 -> {
                    if (row - 1 >= 0 && col - 1 >= 0 && triangle!![row - 1]!![col - 1] == -1) {
                        row--
                        col--
                    } else {
                        direct = (direct + 1) % 3

                        if (row + 1 <= n - 1 && triangle!![row + 1]!![col] == -1) {
                            row++
                        } else {
                            break@loop
                        }
                    }
                }

                else -> {

                }
            }
        }

        var count = 0
        answer = IntArray(total)
        for (i in triangle!!.indices) {
            for (j in triangle!![i]!!.indices) {
                answer[count++] = triangle!![i]!![j]
//                print(triangle!![i]!![j])
            }
//            println()
        }

        return answer
    }
}

//class Solution {
//    fun solution(n: Int): IntArray {
//        num = n
//        triangle = Array(n) { null }
//
//        for (i in 0 until n) {
//            total += i + 1
//            triangle!![i] = Array(i + 1) { -1 }
//        }
//
//
////        println("@@@@ $total")
//        var answer: IntArray = IntArray(total)
//
//        moveDown(0, 0, 1)
//
//        var count = 0
//        for (i in 0 until n) {
//            for (j in 0..i) {
////                print("${triangle!![i]!![j]} ")
//                answer[count] = triangle!![i]!![j]
//                count++
//            }
////            println()
//        }
//
//        return answer
//    }
//
//    private fun moveDown(row: Int, col: Int, count: Int) {
////        if(endFlag) {
////            return
////        }
//
//        if (row >= num) {
//            if (count > total) {
//                endFlag = true
//                return
//            } else {
//                moveRight(row - 1, col + 1, count)
//                return
//            }
//        }
//
//        if (triangle!![row]!![col] != -1) {
//            if(col+1 < row) {
//                moveRight(row-1, col+1, count)
//            }
////            println("row $row col $col ")
////            println(triangle!![row]!![col])
//            return
//        }
//
////        println("row ${row} col ${col} count ${count}")
//
//        triangle!![row]!![col] = count
//
//        moveDown(row + 1, col, count + 1)
//    }
//
//    private fun moveRight(row: Int, col: Int, count: Int) {
////        if(endFlag) {
////            return
////        }
//
//        if (col >= num) {
//            if (count > total) {
//                endFlag = true
//                return
//            } else {
//                moveUp(row - 1, col - 2, count)
//                return
//            }
//        }
//
//        if (triangle!![row]!![col] != -1) {
//            if(row-1 >= 0 && col - 2 >= 0) {
//                moveUp(row-1, col-2, count)
//            }
//            return
//        }
////        println("row ${row} col ${col} count ${count}")
//
//        triangle!![row]!![col] = count
//        moveRight(row, col + 1, count + 1)
//    }
//
//    private fun moveUp(row: Int, col: Int, count: Int) {
////        if(endFlag) {
////            println("!")
////            return
////        }
//
//        if (row < 0 || col < 0 || triangle!![row]!![col] != -1) {
//            if (count > total) {
//                return
//            } else {
//                moveDown(row + 2, col + 1, count)
//                return
//            }
//        }
////        println("row ${row} col ${col} count ${count}!!")
//
//        triangle!![row]!![col] = count
////        println(count)
//        moveUp(row - 1, col - 1, count + 1)
//    }
//}
