object Main extends App {
    def example = 2      // evaluated when called
    val example1 = 2      // evaluated immediately
    lazy val example2 = 2 // evaluated once when needed

    def square(x: Double)    // call by value: evaluates the function arguments before calling the function
    def square(x: => Double) // call by name: evaluates the function first, and then evaluates the arguments if need be
    def myFct(bindings: Int*) = { ... } // bindings is a sequence of int, containing a varying # of arguments
    println("test")
}