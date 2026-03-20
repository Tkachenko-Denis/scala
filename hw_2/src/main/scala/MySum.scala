object MySum {
  def apply(a: List[Int]): Int = {
    a.foldLeft(0) { (sum, value) =>
      sum + value
    }
  }
}
