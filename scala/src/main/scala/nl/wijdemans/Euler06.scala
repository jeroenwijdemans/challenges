package nl.wijdemans

import scala.Predef._

;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?  104743 ?
 */
object Euler06 {

  val msg = "Hello, world!"

  def main(args: Array[String]) {
    run()
  }

  def run() {
    println("Start calculating")
    println("cpc and c can be used as input values to quickly re-calculate a big prime")

    // examples: ..........cpc: 9157 - c: 94999
    var currentPrime: Int = 0;
    var currentPrimeCounter: Int = 9157;
    var counter: Int = 94999;
    do {
      counter = counter + 1
      if (counter % 100 == 0) print(".")
      var prime = true
      for (j <- 2 to counter - 1) {
        if (counter % j == 0) {
          prime = false
        }
      }
      if (prime) {
        currentPrimeCounter = currentPrimeCounter + 1
        currentPrime = counter
      }
      if (counter % 1000 == 0) println("cpc: " +currentPrimeCounter + " - c: " + currentPrime)
    } while (currentPrimeCounter < 10001)



    println("Last Prime  " + currentPrime)
  }

  def isPrime(i: Int, l: Array[Int]) {
    print(i)
  }


}