package programmers.level1.신고결과받기

fun main() {
    val id_list = arrayOf("muzi", "frodo", "apeach", "neo")
    val report = arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi")
    val k = 2

    val solution = Solution()

    val result = solution.solution(id_list, report, k)

    for(element in result) {
        print("$element,")
    }
}

class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer = mutableListOf<Int>()

        val userMap = mutableMapOf<String, User>()
        for(id in id_list) {
            userMap.putIfAbsent(id, User(id, 0, 0))
        }

        val reportSet = mutableSetOf<String>()
        for (element in report) {
            reportSet.add(element)
        }

        for (element in reportSet) {
            val fromTo = element.split(" ")
            val from = fromTo[0]
            val to = fromTo[1]

            val user = userMap[to] ?: continue
            user.increaseReportCount()
        }

        for(element in reportSet) {
            val fromTo = element.split(" ")
            val from = fromTo[0]
            val to = fromTo[1]

            val reportTo = userMap[to] ?: continue

            if(reportTo.getReportCount() >= k) {
                val reportFrom = userMap[from]?: continue
                reportFrom.increaseMailCount()
            }
        }

        for(id in id_list) {
            val user = userMap[id] ?: continue

            answer.add(user.getMailCount())
        }

        return answer.toIntArray()
    }
}

class User(
    private val userId: String,
    private var reportCount: Int,
    private var mailCount: Int
) {
    fun getUserId() = this.userId

    fun getReportCount() = this.reportCount

    fun getMailCount() = this.mailCount

    fun increaseReportCount() {
        this.reportCount++
    }

    fun increaseMailCount() {
        this.mailCount++
    }
}