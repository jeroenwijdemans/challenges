package nl.wijdemans

/**
 *

A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a^2 + b^2 = c^2

For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.

 */
object Euler09 {
  def main(args: Array[String]) {
    run()
  }

  def run() {
    var counter = 0

    // check: a = 375, b = 200, c=425          == 31875000

    //    for (a <- 1 to 998) {
    //      for (b <- a to (999 - a)) {
    //        for (c <- (a + b) to (1000 - (a + b))) {

    for (a <- 1 to 998) {
            for (b <- 1 to 1000) {
              for (c <- 1 to 1000) {
                if (a + b + c == 1000) {
            if (a * a + b * b == c * c) {
              println("check: a = " + a + ", b = " + b + ", c=" + c)
              println("product = " + (a*b*c));
            }
            counter += 1
          }
        }

      }



    }


    // a + b = 1000 - c
  }
}