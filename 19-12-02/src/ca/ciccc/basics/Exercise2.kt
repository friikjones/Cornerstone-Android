package ca.ciccc.exercises


/// Change the 'sum' function so that it was declared as an extension to List<Int>.
infix fun List<Int>.sum(list: List<Int>): Int {
    var result = 0
    for (i in this) {
        result += i
    }
    return result
}

fun main() {
    //val sum = sum(listOf(1, 2, 3))
    //println(sum)
    val sum2 = listOf(1, 2, 3).sum()
    println(sum2)
}