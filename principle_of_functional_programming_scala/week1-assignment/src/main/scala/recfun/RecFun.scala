package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (r == 0 || c == 0 || c == r) 1
    else if (c > r) 0
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
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

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def iter(money: Int, coins: List[Int]): Int = {
        if (coins.isEmpty || money < 0) 0
        else if (money == 0) 1
        else iter(money - coins.head, coins) + iter(money, coins.tail)
    }

    if (money <= 0) 0
    else iter(money, coins.sorted.reverse)
  }
}
