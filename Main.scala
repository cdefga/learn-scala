object Main extends App {
    def sqrt(x: Double) = {
        def abs(x: Double) = if (x >= 0 ) x else -x

        def sqrtIter(guess: Double): Double =
            if (isGoodEnough(guess)) guess
            else sqrtIter(improve(guess))

        def isGoodEnough(guess: Double): Boolean =
            abs(guess * guess - x) / x < 0.001

        def improve(guess: Double) =
            (guess + x / guess) / 2
        
        sqrtIter(1.0)
    }

    def pascal_triangle() = {
        def pascal(c: Int, r: Int): Int = {
            if (r == 0 || c == 0 || c == r) 1
            else if (c > r) 0
            else pascal(c - 1, r - 1) + pascal(c, r - 1)
        }

        println("Pascal's Triangle")
        for (row <- 0 to 10) {
            for (col <- 0 to row)
                print(s"${pascal(col, row)} ")
            println()
        }
    }

    def balance(chars: List[Char]): Boolean = {
        def iter(chars: List[Char], count: Int): Boolean = {
            // println(s"${chars.head}, ${count}")
            if (chars.tail.isEmpty && count == 1) true
            else if (chars.tail.isEmpty && count != 1) false
            else if (chars.head == '(') iter(chars.tail, count + 1)
            else if (chars.head == ')') iter(chars.tail, count - 1)
            else iter(chars.tail, count)
        }
        iter(chars, 0)
    }
    // val res = balance("(if (zero? x) max (/ 1 x))".toList)
    // println(res)

    def filter(p: Int => Boolean, x: Int): AnyVal = if (p(x)) x else false
    // println(filter(x => x > 3, 4))

    def test_list(list: List[Int]): Unit = {
        // println(s"length: ${list.length}")
        // println(s"last: ${list.last}")
        // println(s"init: ${list.init}")
        // println(s"tail: ${list.tail}")
        // println(s"take 3 : ${list take 3}")
        // println(s"drop 3 : ${list drop 3}")
        // println(s"apply 3 : ${list apply 3} ${list(3)}")
        val reduced = list.reduce((x,y) => x+y)
        val max = list.reduce(_ max _)
        println(reduced)
        println(max)
    }
    test_list(List(1,2,3,4))
}