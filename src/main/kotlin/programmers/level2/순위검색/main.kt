package programmers.level2.순위검색

import java.util.*

fun main() {
    val scr = Scanner(System.`in`)

    val info = arrayOf<String>("java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50")
    val query = arrayOf<String>("java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150")

    val solution = Solution()

    println(solution.solution(info, query))
}

val map = mutableMapOf<String, List<Integer>>()

class Solution {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()

        val persons = mutableListOf<Person>()
        val queries = mutableListOf<Query>()
        var infos = mutableListOf<MutableList<String>>()
        info.forEach {
            val splitedList = it.split(" ")

            val person = Person(
                splitedList[0],
                splitedList[1],
                splitedList[2],
                splitedList[3],
                splitedList[4].toInt()
            )

            persons.add(person)
        }

        query.forEach {
            val splitedList = it.split(" and ", " ")

            val query = Query(
                splitedList[0],
                splitedList[1],
                splitedList[2],
                splitedList[3],
                splitedList[4].toInt()
            )

            queries.add(query)
        }



        println("Person")
        persons.forEach {
            println("언어: ${it.language} 직군: ${it.backOrFront} 경력: ${it.grade} 소울푸드: ${it.soulFood} 점수: ${it.score}")
        }

        println("Query")
        queries.forEach {
            println("언어: ${it.language} 직군: ${it.backOrFront} 경력: ${it.grade} 소울푸드: ${it.soulFood} 점수: ${it.score}")
        }

        return answer
    }

    fun inputValue() {

    }
}

class Person constructor(
    val language:String = "",
    val backOrFront:String ="",
    val grade:String = "",
    val soulFood:String = "",
    val score:Int = 0
)

class Query constructor(
    val language:String = "",
    val backOrFront:String ="",
    val grade:String = "",
    val soulFood:String = "",
    val score:Int = 0
)

