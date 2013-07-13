package nl.wijdemans

/**
 *
n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!

 */
object Euler20 {
  def main(args: Array[String]) {
    assert(fac(3L) == 6)
    assert(fac(10L) == 3628800)
    assert(facSum(3L) == 6)
    assert(facSum(10L) == 27)

    assert(fac(50L) == BigInt.apply("30414093201713378043612608166064768844377641568960512000000000000"))
    assert(fac(100L) == BigInt.apply("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"))
    assert(facSum(100L) == 648L)
  }

  def fac(n: Long): BigInt = {
    if (n == 1) {
      return 1
    }
    n * fac(n - 1)
  }

  def facSum(n: Long): Long = {
    val facN = fac(n)
    println("fac N = " + facN)
    val chars = facN.toString
    var sum = 0L;
    chars.foreach {
      case c => sum += Integer.valueOf(c.toString)
    }
    println("Sum is " + sum)
    return sum
  }


}