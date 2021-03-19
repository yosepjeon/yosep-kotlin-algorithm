package programmers.level1.두개뽑아서더하기

import java.util.stream.Collectors

class Solution {
    fun solution(numbers: IntArray): IntArray {
        var list = mutableListOf<Int>()
        val numbersDp = Array<IntArray>(numbers.size) { IntArray(numbers.size) }

        val numbersLen = numbers.size - 1
        for(i in 0..numbersLen) {
            for(j in 0..numbersLen) {
                if(i == j)
                    continue
                if(numbersDp[i][j] != 0)
                    continue

                list.add(numbers[i] + numbers[j])
                numbersDp[i][j] = 1
                numbersDp[j][i] = 1
            }
        }

        val answer = list
            .stream()
            .distinct()
            .sorted { num1: Int, num2: Int -> num1 - num2 }
            .collect(Collectors.toList())
            .toIntArray()

        return answer
    }
}