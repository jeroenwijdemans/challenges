package nl.wijdemans


import annotation.tailrec

/**


The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:
13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.

  */
object Euler14 {

  private val START : Long = 1000 * 1000

  val mapWithExistingCalcAndItsSize = scala.collection.mutable.Map[Long, Long]()


  def main(args: Array[String]) {

    assert(6 == calculateFlowFrom(5))
    assert(10 == calculateFlowFrom(13))
    assert(8 == calculateFlowFrom(20))
    assert(20 == calculateFlowFrom(60))

    for (i <- 1L to START) {
      if (i%300==0) print(".")
      val thisChainLength = calculateFlowFrom(i);
      mapWithExistingCalcAndItsSize += (i -> thisChainLength)
//      println(">> Chain for i = '" + i + "' is '" + thisChainLength+"'")
    }
    println ("Done calculating, start filtering")
    var biggest : Long = 0
    var biggestNumber : Long = 0
    mapWithExistingCalcAndItsSize foreach {
      case (key, value) =>
        if (biggestNumber < value) {
          biggestNumber = value
          biggest = key
        }
    }

    println("Largest chain from 1 to " + START + " = " + biggestNumber + " for " + biggest)
  }

  def calculateFlowFrom(n: Long): Long = {
    @tailrec
    def calculateFlowFromHelper(n: Long, length: Long): Long = {
//      if (mapWithExistingCalcAndItsSize.contains(n)) {
//        return mapWithExistingCalcAndItsSize.getOrElse(n, 1)
//      }

      if (n == 1) {
        return length + 1
      }
      var nNew: Long = 0
      if (n % 2 == 0) {
        nNew = even(n)
      }
      else {
        nNew = odd(n)
      }
      return calculateFlowFromHelper(nNew, 1 + length);
    }
    return calculateFlowFromHelper(n, 0)
  }

  def odd(n: Long): Long = {
     return n * 3 + 1
  }

  def even(n: Long): Long = {
    return n / 2;
  }

}