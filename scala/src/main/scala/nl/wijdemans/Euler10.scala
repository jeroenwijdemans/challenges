package nl.wijdemans

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.

 Using http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes

 */
object Euler10 {
  def main(args: Array[String]) {
    run()
  }

  //    val BILLION = 2 * 1000 * 1000 * 1000
  val BILLION = 2 * 1000 * 1000 * 1000
  val MILLION =2 * 1000 * 1000
  val TEN_THOUSAND = 10 * 1000
  val TEN = 1 * 10

  // 2 B=   (needs 2G)
  // 1 M = 37550402023 (needs 2G)
  // 10k = 5736396
  // 10 = 17

  def run() {
    val GOAL: Int = MILLION
    val STEP: Int = MILLION
    //    val GOAL: Int = TEN_THOUSAND
    //    val STEP: Int = TEN

    // 165 + 17

    println("Start calculating sum all primes below " + GOAL + " (taking steps of " + STEP + ")");

    var currentPrimeSum: Long = 0L
    val totalSteps: Int = (GOAL / STEP).toInt

    println("Taking " + totalSteps + " steps to reach a total primes' sum.")
    for (t <- 0 to totalSteps - 1) {
      currentPrimeSum += sieve(t * STEP, t * STEP + STEP)
    }
    println("Sum : " + currentPrimeSum)
  }


  def sieve(from: Int, end: Int): Long = {
    println("Beginning sieve range from " + from + " to " + end)
    val offset: Int = from
    val size = end - from
    val p: Array[Boolean] = new Array[Boolean](size + 1)
    for (i: Int <- 0 to size) {
      p(i) = true
    }

    if (offset == 0) {
      p(0) = false;
      p(1) = false;
    }


    for (i: Int <- from to end) {
      if (p(i - offset)) {

        val K = Math.round(Math.sqrt(end+offset)) + 1
        var counter = offset
        val srt = i * i: Long
        var j = srt

//        println("Check K '" + K + "' fall in selection below i '" + i + "'")
        if (i < K) {
//          println("From beginning '" + j + "' to end '" + end + "'")
          while (j <= end) {
//            println("Set p(j) to false at '" + j + "' (counter = '" + counter + "')")
            p(j.toInt - offset) = false
            //}
            j = srt + counter * i
            counter += 1
          }
        }
      }

    }

    var currentPrimeSum = 0L
    for (i: Int <- 0 to size) {
      if (p(i)) {
//        println("Found prime at " + i + " with value " + (i + offset))
        currentPrimeSum += (i + offset)
      }
    }
    println("Sieve part for " + from + " to " + end + " yielded:  " + currentPrimeSum)
    return currentPrimeSum;
  }
}