object Stack {

  def main(args: Array[String]) {
    exploding
  }

  def exploding {
    def listLength1(list: List[_]): Int = {
      if (list == Nil) 0
      else 1 + listLength1(list.tail)
    }

    var list1 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var list2 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    1 to 15 foreach (x => list2 = list2 ++ list2)

    println(listLength1(list1))
    println(listLength1(list2))
  }
}