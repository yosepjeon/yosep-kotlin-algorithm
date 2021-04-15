package programmers.level2.삼각달팽이

var num = 0
var total = 0
var triangle: Array<Array<Int>?>? = null
var endFlag = false

fun main() {
    val n = 50
    val solution = Solution()
    val result = solution.solution(n)

    result.forEach {
        print("$it ")
    }
}

class Solution {
    fun solution(n: Int): IntArray {
        num = n
        triangle = Array(n) { null }

        for (i in 0 until n) {
            total += i + 1
            triangle!![i] = Array(i + 1) { -1 }
        }


        println("@@@@ $total")
        var answer: IntArray = IntArray(total)

        moveDown(0, 0, 1)

        var count = 0
        for (i in 0 until n) {
            for (j in 0..i) {
//                print("${triangle!![i]!![j]} ")
                answer[count] = triangle!![i]!![j]
                count++
            }
//            println()
        }

        return answer
    }

    private fun moveDown(row: Int, col: Int, count: Int) {
//        if(endFlag) {
//            return
//        }

        if (row >= num) {
            if (count > total) {
                endFlag = true
                return
            } else {
                moveRight(row - 1, col + 1, count)
                return
            }
        }

        if (triangle!![row]!![col] != -1) {
            if(col+1 < row) {
                moveRight(row-1, col+1, count)
            }
//            println("row $row col $col ")
//            println(triangle!![row]!![col])
            return
        }

//        println("row ${row} col ${col} count ${count}")

        triangle!![row]!![col] = count

        moveDown(row + 1, col, count + 1)
    }

    private fun moveRight(row: Int, col: Int, count: Int) {
//        if(endFlag) {
//            return
//        }

        if (col >= num) {
            if (count > total) {
                endFlag = true
                return
            } else {
                moveUp(row - 1, col - 2, count)
                return
            }
        }

        if (triangle!![row]!![col] != -1) {
            if(row-1 >= 0 && col - 2 >= 0) {
                moveUp(row-1, col-2, count)
            }
            return
        }
//        println("row ${row} col ${col} count ${count}")

        triangle!![row]!![col] = count
        moveRight(row, col + 1, count + 1)
    }

    private fun moveUp(row: Int, col: Int, count: Int) {
//        if(endFlag) {
//            println("!")
//            return
//        }

        if (row < 0 || col < 0 || triangle!![row]!![col] != -1) {
            if (count > total) {
                return
            } else {
                moveDown(row + 2, col + 1, count)
                return
            }
        }
//        println("row ${row} col ${col} count ${count}!!")

        triangle!![row]!![col] = count
        println(count)
        moveUp(row - 1, col - 1, count + 1)
    }
}
