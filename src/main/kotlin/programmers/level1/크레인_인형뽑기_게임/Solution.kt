package programmers.level1.크레인_인형뽑기_게임

import java.util.*

class Solution {
    var result:Int = 0

    fun solution(board: Array<IntArray>, moves: IntArray): Int {

        val basket = Stack<Int>()

        for (col in moves) {
            catchDoll(board, basket, col-1)
        }

        return result
    }

    private fun catchDoll(board: Array<IntArray>, basket: Stack<Int>, col: Int) {
        val rowSize = board.size-1
        for(row:Int in 0..rowSize) {
            if(board[row][col] == 0) {
                continue
            }else {
                insertToBasket(basket, board[row][col])
                board[row][col] == 0
                break
            }
        }

    }

    private fun insertToBasket(basket: Stack<Int>, doll: Int) {
        when {
            basket.isEmpty() -> {
                basket.push(doll)
            }
            basket.peek() == doll -> {
                result += 2
                basket.pop()
            }
            else -> {
                basket.push(doll)
            }
        }
    }
}