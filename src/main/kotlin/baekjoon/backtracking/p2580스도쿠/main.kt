package baekjoon.backtracking.p2580스도쿠

import java.util.*

var isComplete = false

class ZeroArea(
    var row: Int,
    var col: Int,
    var visited: Array<Boolean> = Array(9) { false }
)

val map = Array<Array<Int>>(9) {
    Array<Int>(9) {
        0
    }
}

fun main() {
    val scr = Scanner(System.`in`)
    val zeroAreas = mutableListOf<ZeroArea>()

    for (i in 0 until 9) {
        for (j in 0 until 9) {
            map[i][j] = scr.nextInt()

            if (map[i][j] == 0) {
                zeroAreas.add(ZeroArea(i, j))
            }
        }
    }

    for (zeroArea in zeroAreas) {
        checkRow(zeroArea)
        checkCol(zeroArea)
        checkSquare(zeroArea)
    }

    val zeroAreasSize = zeroAreas.size

    makeSudoku(zeroAreas, 0, zeroAreasSize)

    printlnResult()
}

fun printlnResult() {
    for (i in 0 until 9) {
        for (j in 0 until 9) {
            print("${map[i][j]} ")
        }
        println()
    }
}

fun checkRow(element: ZeroArea) {
    for (i in 0..8) {
        if (map[i][element.col] != 0) {
            element.visited[map[i][element.col] - 1] = true
        }
    }
}

fun checkCol(element: ZeroArea) {
    for (i in 0..8) {
        if (map[element.row][i] != 0) {
            element.visited[map[element.row][i] - 1] = true
        }
    }
}

fun checkSquare(element: ZeroArea) {
    val r = if (element.row in 0..2) {
        0
    } else if (element.row in 3..5) {
        3
    } else if (element.row in 6..8) {
        6
    } else {
        -1
    }

    val c = if (element.col in 0..2) {
        0
    } else if (element.col in 3..5) {
        3
    } else if (element.col in 6..8) {
        6
    } else {
        -1
    }

    for (i in 0..2) {
        for (j in 0..2) {
            if (map[r + i][c + j] != 0) {
                element.visited[map[r + i][c + j] - 1] = true
            }
        }
    }
}

fun checkValidRow(element: ZeroArea, value: Int): Boolean {
    for (i in 0..8) {
        if (map[i][element.col] == value) {
            return false
        }
    }

    return true
}

fun checkValidCol(element: ZeroArea, value: Int): Boolean {
    for (i in 0..8) {
        if (map[element.row][i] == value) {
            return false
        }
    }

    return true
}

fun checkValidSquare(element: ZeroArea, value: Int): Boolean {
    val r = when (element.row) {
        in 0..2 -> {
            0
        }
        in 3..5 -> {
            3
        }
        in 6..8 -> {
            6
        }
        else -> {
            -1
        }
    }

    val c = when (element.col) {
        in 0..2 -> {
            0
        }
        in 3..5 -> {
            3
        }
        in 6..8 -> {
            6
        }
        else -> {
            -1
        }
    }

    for (i in 0..2) {
        for (j in 0..2) {
            if (map[r + i][c + j] == value) {
                return false
            }
        }
    }

    return true
}

fun makeSudoku(zeroAreas: MutableList<ZeroArea>, index: Int, zeroAreasSize: Int) {
    if (index >= zeroAreasSize) {
        isComplete = true
        return
    }

    val zeroArea = zeroAreas[index]

    for (i in 0..8) {
        if (!zeroArea.visited[i]) {
            if (checkValidCol(zeroArea, i + 1) && checkValidRow(zeroArea, i + 1) && checkValidSquare(zeroArea, i + 1)) {
                map[zeroArea.row][zeroArea.col] = i + 1
                makeSudoku(zeroAreas, index + 1, zeroAreasSize)
                if (isComplete) {
                    return
                } else {
                    map[zeroArea.row][zeroArea.col] = 0
                }
            }
        }
    }
}