package nl.wijdemans

import com.sun.tools.corba.se.idl.StringGen

/**


215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 21000?

  */
object Euler16 {
  def main(args: Array[String]) {
    var a: java.math.BigDecimal = new java.math.BigDecimal(1)
    val TWO = new java.math.BigDecimal(2)
    for (i <- 1 to 1000) {
      a = a.multiply(TWO)
    }
    var tot = a.toPlainString();
    println("BD : " + tot);

    var x = 0

    tot.foreach {
      case ch => x += Integer.valueOf(ch.toString())
    }

    // 1366
    println("Sum : " + x)

  }
}