package ca.ciccc.basics

val question: String = "this is a val."

fun main() {
    println(question)
    printshit()
    println(min(b=1,a=2))
    testSeparator()
    testSeparator("a")
    testSeparator(amount = 5)
}


fun printshit(){
    println("some shit")
}

fun min(a:Int, b:Int) = if (a < b) a else b

fun testSeparator(character: String="A", amount: Int=3){
    repeat(amount){
        print(character)
    }
}