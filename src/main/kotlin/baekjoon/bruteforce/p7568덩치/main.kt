package baekjoon.bruteforce.p7568덩치

import java.util.*

fun main(args: Array<String>) {
    var N: Int
    var sc = Scanner(System.`in`)

    N = sc.nextInt()

    var persons = mutableListOf<Person>()

    var i = 0
    while(i < N) {
        var weight = sc.nextInt()
        var height = sc.nextInt()
        var person = Person(weight,height,1)

        persons.add(person)

        i++;
    }


    for(person1 in persons) {
        for(person2 in persons) {

           if(person1.weight <person2.weight && person1.height < person2.height){
               person1.rank++
           }

        }
    }

    var sb = StringBuffer()
    for(person in persons) {
        sb.append("${person.rank} ")
    }

    println(sb.toString())
}

data class Person(
    var weight:Int,
    var height:Int,
    var rank:Int
) {

}