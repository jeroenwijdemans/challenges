package nl.wijdemans

/**


Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
there are exactly 6 routes to the bottom right corner.

How many such routes are there through a 20×20 grid?

   A   A    A    AA   AA    AAA
   A   AA   AAA   AA   A      A
   AAA  AA    A    A   AA     A

  */
object Euler15 {
  def main(args: Array[String]) {
    val gridSize = 20
    var counter=0

    for (x <- 0 to gridSize) {
      for (y <- x to gridSize) {
        counter+=1
      }
    }

    println("Number of paths " + counter)  // 231

  }
}