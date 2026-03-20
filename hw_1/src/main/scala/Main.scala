object Main {
  def main(args: Array[String]): Unit = {
    val values = Vector(5, 3, 8, 3, 1, 2, 8, 1, 2, 10)

    println(s"Source: $values")
    println(s"MergeSort: ${MergeSort.sort(values)}")
    println(s"Top 5 smallest: ${TopNSort.findSmallest(values, 5)}")
    println(s"UniqueMergeSort: ${UniqueMergeSort.sort(values)}")
  }
}
