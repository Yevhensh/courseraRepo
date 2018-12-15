package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int =
    if (r == 0 || c == 0 || c == r) 1
    else pascal(c, r - 1) + pascal(c - 1, r - 1)


  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def balancer(chars: List[Char], nest: Int): Boolean = {
      if (nest == -1)
        false
      else if (chars.isEmpty)
        nest == 0
      else if (chars.head == '(')
        balancer(chars.tail, nest + 1)
      else if (chars.head == ')')
        balancer(chars.tail, nest - 1)
      else
        balancer(chars.tail, nest)
    }

    balancer(chars, 0)
  }

  /**
    * Exercise 3
    */

  def countChange(money: Int, coins: List[Int]): Int = {
    def countRec(curMoney: Int, coins: List[Int]): Int = {
      if (coins.isEmpty) 0
      else if (curMoney < money) countRec(curMoney + coins.head, coins) + countRec(curMoney, coins.tail)
      else if (curMoney == money) 1
      else 0
    }

    countRec(0, coins)
  }
}
