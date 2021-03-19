package programmers.level1.신규아이디추천

class Main {

}

class Solution {
    fun solution(new_id: String): String {
        var answer: String = new_id

        answer = step1(answer)
        answer = step2(answer)
        answer = step3(answer)
        answer = step4(answer)
        answer = step5(answer)
        answer = step6(answer)
        answer = step7(answer)

        return answer
    }

    fun step1(new_id: String): String {
        return new_id.toLowerCase()
    }

    fun step2(new_id: String): String {
        val sb = StringBuffer()

        new_id.forEach {
            if((it in 'a'..'z') || it in '0'..'9' || it == '-' || it == '_' || it == '.') {
                sb.append(it)
            }
        }

        return sb.toString()
    }

    fun step3(new_id: String): String {
        var result = new_id

        while (result.contains("..")) {
            result = result.replace("..",".")
        }

        return result
    }

    fun step4(new_id: String): String {
        var result = new_id

        var indexOfFirst = result.indexOfFirst { it == '.' }
        if(indexOfFirst != -1 && indexOfFirst == 0) {
            result = result.replaceFirst(".", "")
        }

        var indexOfLast = result.indexOfLast { it == '.' }
        if(indexOfLast != -1 && indexOfLast == result.length-1) {
            result = result.substring(0, indexOfLast)
        }

        return result
    }

    fun step5(new_id: String): String {
        var result = StringBuffer(new_id)

        if(result.isEmpty()) {
            result.append("a")
        }

        return result.toString()
    }

    fun step6(new_id: String): String {
        var result = new_id
        if(new_id.length >= 16) {
            result = result.substring(0, 15)
        }

        var indexOfLast = result.indexOfLast { it == '.' }
        if(indexOfLast != -1 && indexOfLast == result.length-1) {
            result = new_id.substring(0, indexOfLast)
        }

        return result
    }

    fun step7(new_id: String): String {
        var result = StringBuffer(new_id)

        while(result.length <= 2) {
            result = result.append(result.last())
        }

        return result.toString()
    }
}