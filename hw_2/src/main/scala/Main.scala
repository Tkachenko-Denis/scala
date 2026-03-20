object Main {
  def main(args: Array[String]): Unit = {
    val range = MyRange(1, 10)
    val sum = MySum(range)

    println(s"Range: $range")
    println(s"Sum: $sum")
  }
}
