package ca.ciccc.exercises

infix fun <T> T.eq(other: T) {
    if(this == other)
        println("OK")
    else
        println("Error: $this != $other")
}

fun getAnswer() = 7;

fun main() {
    getAnswer() eq("yeah")
    getAnswer() eq(43)
}