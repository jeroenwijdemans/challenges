package nl.wijdemans

/**
 * Find the greatest product of five consecutive digits in the 1000-digit number.

 */
object Euler08 {
  def main(args: Array[String]) {
    run()
  }

  def run() {
    val nr =
      "73167176531330624919225119674426574742355349194934" +
        "96983520312774506326239578318016984801869478851843" +
        "85861560789112949495459501737958331952853208805511" +
        "12540698747158523863050715693290963295227443043557" +
        "66896648950445244523161731856403098711121722383113" +
        "62229893423380308135336276614282806444486645238749" +
        "30358907296290491560440772390713810515859307960866" +
        "70172427121883998797908792274921901699720888093776" +
        "65727333001053367881220235421809751254540594752243" +
        "52584907711670556013604839586446706324415722155397" +
        "53697817977846174064955149290862569321978468622482" +
        "83972241375657056057490261407972968652414535100474" +
        "82166370484403199890008895243450658541227588666881" +
        "16427171479924442928230863465674813919123162824586" +
        "17866458359124566529476545682848912883142607690042" +
        "24219022671055626321111109370544217506941658960408" +
        "07198403850962455444362981230987879927244284909188" +
        "84580156166097919133875499200524063689912560717606" +
        "05886116467109405077541002256983155200055935729725" +
        "71636269561882670428252483600823257530420752963450";

    println("Number size: " + nr.length)

    val holder = new Array[Int](nr.length - 4);

    var size = 1
    for (i <- 0 to nr.length - 5) {
      val ss = String.valueOf(nr.subSequence(i, i + 5));

      println (ss.getClass)
//      println (ss.substring(1).toInt.getClass)
//      println ("v=" +ss.substring(1).toInt)

      var s0 =Integer.valueOf(ss.substring(0,1));
      var s1 =Integer.valueOf(ss.substring(1,2));
      var s2 =Integer.valueOf(ss.substring(2,3));
      var s3 =Integer.valueOf(ss.substring(3,4));
      var s4 =Integer.valueOf(ss.substring(4,5));


//      println ("SS " +ss+ " - S0 " +  ss(0) +" - S1 " + ss(1) + " max:" + (Integer.valueOf(ss.substring(0,1)) * Integer.valueOf(ss.substring(1,2) )))
      holder(i) = s0*s1*s2*s3*s4
//      println("s " + ss + " - s0: " +  ss(0)+ " - s1: " +  ss(1)+ " - s2: " +  ss(2)+ " - s3: " +  ss(3)+ " - s4: " +  ss(4) + " max " + holder(i));
//            println("i " + i + " - x: " + holder(i));
    }

    var tmp: Int = 0
    for (i <- 0 to holder.length-4) {
      if (holder(i) > tmp) {
        tmp = holder(i)
      }
    }

    // 570394440
    print("Largest product : " + tmp)

  }

}